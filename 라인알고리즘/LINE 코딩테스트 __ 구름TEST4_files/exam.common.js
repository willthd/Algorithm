define(['main.localization'], function(localization) {
	var exam_common = {
		exam_index: null,
		user_id: null,
		is_student: false,
		is_teacher: false,

		exam_end_date: null,
		exam_allow_exceed_deadline: false,
		exam_exceed_deadline_days: 0,
		exam_remain_time: 0,

		sync_time_interval: -1,
		blink_time_interval: -1,

		init: function(options) {
			var self = this;
			
			this.lecture_index = options.lecture_index;
			this.exam_index = options.exam_index;
			this.user_id = options.user_id;
			this.is_student = options.is_student;
			this.is_teacher = options.is_teacher;
			this.is_admin = options.is_admin;
			this.is_sample = options.is_sample;

			if (this.exam_index !== 'quiz_preview') {
				this.init_timer();
			}
		},
		
		set_lecture_guide_resizable: function (start, stop) {
			var previous_width = 0;
			
			var set_percentage_width = function (width, element) {
				var w_width = $(window).width();
				var width_percent = width / w_width * 100;
				element.css('width', width_percent.toString() + '%');
				element.next().css('width', (100 - width_percent).toString() + '%');
			};
			
			$('.lecture-guide').resizable({
				handles: 'e',
				minWidth: 360,
				maxWidth: $(window).width() * 0.7,
				helper: "ui-resizable-helper-e",
				create: function() {
					var self = $(this);
					var contents = $('.lecture-guide-contents');

					$(this).find('.ui-resizable-e')
						.append('<i class="fa fa-arrows-h"></i>')
						.tooltip({
							'placement': 'right',
							'title': localization.get_value('close_by_dblclick')
						})
						.dblclick(function () {
							previous_width = self.width();
						
							self
								.collapse('hide')
								.next().width('100%');
						});
					
					self
						.on('hide.bs.collapse', function () {
							contents.hide();
						})
						.on('hidden.bs.collapse', function () {
							contents.width(previous_width).show();
						})
						.on('shown.bs.collapse', function () {
							contents.width('');

							set_percentage_width(previous_width, self);
						});
				},
				start: function() {
					if(start) {
						start();
					}
				},
				stop: function(e, ui) {
					set_percentage_width(ui.size.width, ui.element);
					
					if(stop) {
						stop();
					}
				}
			});
		},

		init_timer: function() {
			var self = this;
			if (!this.is_student && !this.is_teacher && !this.user_id) {
				this.sync_time();
			} else {
				var random_interval = (Math.floor(Math.random() * 180) + 120) * 1000;
				this.sync_time();
				this.sync_time_interval = setInterval(function() {
					self.sync_time();
				}, random_interval);
			}
		},

		sync_time: function() {
			var self = this;

			$.get('/exam/getdate', {
				exam_index: this.exam_index,
				_: new Date().getTime()
			}, function(res) {
				if (res) {
					var exam_date = res.exam_date;
					var personal_date = res.personal_date || false;

					self.exam_remain_time = res.remain_time;
					self.set_popover_text(res);
					//set end date
					if (personal_date && personal_date.start_time && personal_date.end_time) {
						self.exam_end_date = personal_date.end_time;
					} else if (exam_date.end_date) {
						self.exam_end_date = exam_date.end_date; // exam_end_date for current exam.
					} else {
						self.exam_end_date = null;
					}
					
					self.exam_allow_exceed_deadline = exam_date.allow_exceed_deadline || false;
					self.exam_exceed_deadline_days = exam_date.exceed_deadline_days || 0;
					
					if(self.exam_remain_time <= 10 * 60 * 1000) {	// get submit status 10 minutes before exam ends
						self.get_submit_status();
					}
					
					if (!(self.is_teacher || self.is_admin || self.is_sample) && self.check_end_deadline() && !exam_date.allow_exceed_deadline_access) {
						if(typeof tutorial_editor !== 'undefined') {
							tutorial_editor.is_link_unload = true;
						}
						
						// self.go_to_lecture(localization.get_value('exam_openable_setting_change'));
						self.show_finale_page();
					}

					clearInterval(self.blink_time_interval);
					self.blink_time_interval = setInterval(function() {
						self.blink_time(exam_date.allow_exceed_deadline_access);
						self.exam_remain_time -= 1000;
					}, 1000);
				} else {
					self.exam_end_date = null;
				}
			});
		},

		blink_time: function(allow_exceed_deadline_access) {
			if (!this.exam_end_date) {
				clearInterval(this.sync_time_interval);
				clearInterval(this.blink_time_interval);

				$('#exam_countdown_clock .exist_limit').hide();
				$('#exam_countdown_clock .ended_exam').hide();
				$('#exam_countdown_clock .no_limit, .quiz_save, .quiz_submit, .submit_answer').show();
			} else {
				var end_time = new Date(this.exam_end_date).getTime();
				var remain_time = this.exam_remain_time; //end_time - new Date().getTime();

				var limit = null;

				var _h = Math.floor(remain_time / 1000 / (60*60));
				var _m = Math.floor(remain_time / 1000 / 60 % 60);
				var _s = Math.floor(remain_time / 1000 % 60);
				
				if(remain_time <= 10 * 60 * 1000) {	// get submit status 10 minutes before exam ends
					this.get_submit_status();
				}

				if (remain_time <= 0) {
					clearInterval(this.sync_time_interval);
					clearInterval(this.blink_time_interval);

					$('#exam_countdown_clock .exist_limit').hide();
					$('#exam_countdown_clock .no_limit').hide();
					$('#exam_countdown_clock .ended_exam').show();

					is_end_exam = true;

					if(!(this.is_teacher || this.is_admin || this.is_sample) && this.check_end_deadline() && !allow_exceed_deadline_access) {
						// this.go_to_lecture('<b>' + localization.get_value('exam_ended') + '</b>');
						this.show_finale_page();
					}
					
					$('.quiz_save, .quiz_submit, .submit_answer').toggle(!is_end_deadline);
				} else if (_h < 24) {
					is_end_exam = false;
					
					if (_m <= 9) {
						_m = '0' + _m;
					}
					
					if (_s <= 9) {
						_s = '0' + _s;
					}
					
					limit = _h + ':' + _m + ':' + _s;

					$('#exam_countdown_clock .ended_exam').hide();
					$('#exam_countdown_clock .no_limit').hide();
					$('#exam_countdown_clock .exist_limit, .quiz_save, .quiz_submit, .submit_answer').show();

					$('#exam_countdown_clock .clock').text(limit);
				} else {
					limit = Math.floor(_h / 24) + localization.get_value('exam_date');
					var extra_h = _h % 24;
					if (extra_h > 0) {
						limit = limit + ' ' + extra_h + localization.get_value('exam_hours');
					}

					$('#exam_countdown_clock .ended_exam').hide();
					$('#exam_countdown_clock .no_limit').hide();
					$('#exam_countdown_clock .exist_limit, .quiz_save, .quiz_submit, .submit_answer').show();

					$('#exam_countdown_clock .clock').text(limit);
				}
			}
		},
		
		check_end_deadline: function () {
			if(this.exam_remain_time > 0) {
				is_end_deadline = false;
			} else if (this.exam_allow_exceed_deadline && this.exam_exceed_deadline_days) {
				var deadline_time = new Date(this.exam_end_date).getTime() + 1000 * 60 * 60 * 24 * this.exam_exceed_deadline_days - new Date().getTime();

				if (deadline_time <= 0) {
					is_end_deadline = true;
				} else {
					is_end_deadline = false;
				}
			} else {
				is_end_deadline = true;
			}
			
			return is_end_deadline;
		},
		
		// set quizzes submit status in exam finale modal. Jayde-Im.
		// quiz (Object | Null) : quiz data | emptying quiz list
		set_finale_quiz: function (quiz) {
			quiz = quiz || {};
			
			var submit_result = quiz.submitted ? localization.get_value('submitted') : localization.get_value('not_submitted');
			var quiz_list = $('#exam_end .list-group');
			var target_quiz = $('.list-group-item[index="' + quiz.index + '"]');

			if (target_quiz.length === 0) {
				quiz_list.append([
					'<li class="list-group-item', quiz.submitted ? ' list-group-item-success' : '', '" index="', quiz.index, '">',
						'<span class="finale_quiz_title">', quiz.title, '</span>',
						'<span class="pull-right">',
							'<strong>', submit_result, '</strong>',
						'</span>',
					'</li>'
				].join(''));
			} else {
				if (quiz.title) {
					target_quiz.find('.finale_quiz_title').text(quiz.title);
				}
				if (quiz.submitted) {
					target_quiz.addClass('list-group-item-success');
					target_quiz.find('strong').text(submit_result);
				}
			}
		},
		
		// get submit status of contents/tutorial quizzes. Used when exam has both contents and tutorial quizzes. Jayde-Im.
		get_submit_status: function () {
			var self = this;
			
			if (this.has_submit_status) {
				return;
			} else {
				this.has_submit_status = true;
			}
			
			// if(this.quiz_type === 'contents') {	// get tutorial quizzes
				$.get('/quiz/get_label', {
					'exam_index': this.exam_index
				}, function(result) {
					if(result && result.length && typeof(result) !== 'string') {
						result.forEach(function (quiz) {
							self.set_finale_quiz({
								'type': 'set',
								'submitted': quiz.last_submit_date,
								'index': quiz.index,
								title: quiz.title,
							});
						});
					}
				});
			// } else if (this.quiz_type === 'tutorial') {	// get contents quizzes
				$.get('/exam/get_normal_quiz', {
					'index': self.exam_index
				}, function (normal_quiz_data) {
					if(normal_quiz_data) {
						normal_quiz_data.forEach(function (quiz) {
							var try_count = parseInt(quiz.try_count, 10) || 0;
							
							self.set_finale_quiz({
								'type': 'set',
								'submitted': try_count > 0,
								'index': quiz.normal_quiz_data.index
							});
						});
					}
				});
			// }	// else: exam has only contents or tutorial quizzes.
		},
		
		// show exam finale modal when exam ends. Jayde-Im.
		show_finale_page: function () {
			var self = this;
			
			$(window).off('beforeunload');	// there isn't any editor anyway, we are free to go another page
			
			$('#exam_end button').click(function () {
				location.href = '/learn/lecture/' + btoa(self.lecture_index);
			});
			
			$('#exam_end').modal('show');
			$('header, section').remove();
		},
		
		// go to lecture page with message. Jayde-Im.
		// msg (String) : notification of moving page
		go_to_lecture: function (msg) {
			var self = this;
			
			$(window).off('beforeunload');
			toast.show(msg + '<br/>' + localization.get_value('go_to_lecture'), {
				'method': 'warning',
				'forever': true
			});

			$.debounce(5000, function () {
				location.href = '/learn/lecture/' + btoa(self.lecture_index);
			})();
		},

		set_popover_text: function(data) {
			var exam_date = data.exam_date;
			var personal_date = data.personal_date || false;
			
			$('.popover:not(.tour)').remove();
			var text = '';
			
			if (exam_date) {
				if (exam_date.start_date) {
					var date = new Date(exam_date.start_date);
					text += localization.get_value('exam_start_time2') + ' : ' + (date.getMonth() + 1) + localization.get_value('month') + ' ' + date.getDate() + localization.get_value('exam_date') + ' ' + date.getHours() + localization.get_value('hour') + ' ' + date.getMinutes() + localization.get_value('minute') + '<br>';
				}
				if (exam_date.end_date) {
					var date = new Date(exam_date.end_date);
					text += localization.get_value('exam_end_time2') + ' : ' + (date.getMonth() + 1) + localization.get_value('month') + ' ' + date.getDate() + localization.get_value('exam_date') + ' ' + date.getHours() + localization.get_value('hour') + ' ' + date.getMinutes() + localization.get_value('minute') + '<br>';
					
					if (exam_date.allow_exceed_deadline) {
						if (exam_date.exceed_deadline_days) {
							var date = new Date(date.getTime() + 1000 * 60 * 60 * 24 * exam_date.exceed_deadline_days);
							text += localization.get_value('additional_submit_time') + ' : ' + (date.getMonth() + 1) + localization.get_value('month') + ' ' + date.getDate() + localization.get_value('exam_date') + ' ' + date.getHours() + localization.get_value('hour') + ' ' + date.getMinutes() + localization.get_value('minute') + '<br>';
						}
						if (exam_date.exceed_deadline_penalty_percent) {
							text += localization.get_value('deduction_per_day') + '  : -' + exam_date.exceed_deadline_penalty_percent + '%<br>';
						}
					}
				} else {
					text += localization.get_value('exam_end_time2') + ' : ' + localization.get_value('exam_end_date_none') + '<br>';
				}
				
				if (personal_date) {
					if (personal_date.start_time) {
						var date = new Date(personal_date.start_time);
						text = '최초 접속 시각 : ' + (date.getMonth() + 1) + localization.get_value('month') + ' ' + date.getDate() + localization.get_value('exam_date') + ' ' + date.getHours() + localization.get_value('hour') + ' ' + date.getMinutes() + localization.get_value('minute') + '<br>';
					}

					if (personal_date.end_time) {
						var date = new Date(personal_date.end_time);
						text += '시험 종료 예정 시각 : ' + (date.getMonth() + 1) + localization.get_value('month') + ' ' + date.getDate() + localization.get_value('exam_date') + ' ' + date.getHours() + localization.get_value('hour') + ' ' + date.getMinutes() + localization.get_value('minute') + '<br>';
					}
				}
				
			} else {
				text += localization.get_value('exam_end_time2') + ' : ' + localization.get_value('exam_end_date_none') + '<br>';
			}
			
			$('.test_time_button').attr('data-content', text);
		}
	};

	return exam_common;
});