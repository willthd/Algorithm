define(['main.localization', 'exam.common'], function(localization, exam_common) {
	var menu = {
		STATE_CLASS: ['ongoing', 'success', 'challenge', 'submitted'],
		STATE_ICON: ['<i></i>',
					 '<i class="fa fa-check-circle"></i>',
					 '<i class="fa fa-minus-circle"></i>',
					 '<i class="fa fa-arrow-circle-up"></i>'],

		lecture_index: '',
		exam_index: '',
		quiz_index: '',
		exam_data: {},

		accessable_quiz_list: [],

		exam_notice_list: [],

		exam_end_date: null,
		tree_container: null,
		
		pathname: document.location.pathname.indexOf('learn') !== -1 ? '/learn' : '/apply',
		user_agent: navigator.userAgent,

		anon_start_time: null,
		sync_time_interval: -1,
		blink_interval: -1,

		init: function(options) {
			var self = this;
			this.lecture_index = options.lecture_index;
			this.exam_index = options.exam_index;
			this.quiz_index = options.quiz_index;
			this.tree_container = options.tree_container;
			this.is_student = options.is_student;
			this.is_teacher = options.is_teacher;
			this.is_preview = options.is_preview;
			this.is_submitted = options.is_submitted;
			this.user_id = options.user_id;

			exam_common.init(options);
			this.exam_common = exam_common;
			if (this.is_preview) {
				$('.guide_header').hide();
			}
			
			if (options.socket) {
				this.socket = options.socket;
			}

			loader.hide();
			$(document).trigger('exam_menu_loaded');
			
			$('.header_title_link').attr('href', '/' + (this.pathname === '/learn' ? 'lecture' : 'test') + '/' + btoa(self.lecture_index));

			$.get('/exam/get', {
				index: this.exam_index
			}, function(exam_data) {
				self.exam_data = exam_data || {};

				self.load();
			});
		},

		load: function() {
			if (this.exam_index !== 'quiz_preview'){
				this.init_tree();
				this.init_event();
				this.init_socket();
				this.get_exam_notice();
			}

			setTimeout(function() { 
				loader.hide();
			}, 1500);
		},

		init_event: function() {
			var self = this;

			$('.learnpage_curriculum_list_btn').on('click', function() {
				$(this).blur();
				if (!$(this).hasClass('disabled')) {
					var $list = $('.learnpage_curriculum_list');
					if ($list.is(':visible')) {
						$(this).removeClass('list_open');

						$list.hide();
						$('.instruction_content').show();
						$('.emphasis_content').show();
					} else {
						$(this).addClass('list_open');

						$list.show();
						$('.instruction_content').hide();
						$('.emphasis_content').hide();
					}
				}
			});

			$('.learnpage_curriculum_list_close').on('click', function() {
				$('.learnpage_curriculum_list_btn').removeClass('list_open');
				$('.learnpage_curriculum_list').hide();
				$('.instruction_content').show();
				$('.emphasis_content').show();
			});

			$(document).on('click', '#g_confirm_ok', function () {
				window.location.href = self.pathname + "/my";
			});
			
			$(document).on('click', '.move_quiz', function() {
				var $this = $(this);
				var href = $this.attr('quiz_href');
				
				if (self.is_submitted) {
					window.location.href = href;
				} else {
					confirmation.init({
						message: main_localization.get_value('msg_confirm_submit_or_go'),
						yes_text: main_localization.get_value('submit_btn'),
						no_text: main_localization.get_value('dont_submit_and_go'),
						title: main_localization.get_value('dialog_confirmation'),

						yes: function() {
							tutorial_editor.dont_check = true;
							$('.quiz_submit').click();
						},
						
						no: function() {
							$(window).off('beforeunload');
							window.location.href = href;
						},
						
						cancel: function() {}
					}).show();
				}
			});
			
			if (/mobile/i.test(self.user_agent) || /android/i.test(self.user_agent)) {}
			else {
				exam_common.set_lecture_guide_resizable(function () {
					var $entry_container = $('.entry_container');
					if ($entry_container.length) {
						$entry_container.css('pointer-events', 'none');
					}
				}, function () {
					var $entry_container = $('.entry_container');
					if ($entry_container.length) {
						$entry_container.css('pointer-events', 'auto');
					}
				});

				$('.result_content').resizable({
					handles: 'n',
					minHeight: 100,
					maxHeight: $(window).height() * 0.7,
					helper: 'ui-resizable-helper-n',
					create: function() {
						$(this).find('.ui-resizable-n').append('<i class="fa fa-sort"></i>');
					},
					stop: function(e, ui) {
						$(this).css({
							'width': '100%',
							'bottom': 0,
							'top': '',
							'height': 'initial'
						});

						var mini_tab_height = $('.running_result_header').is(':visible') ? parseInt($('.running_result_header').css('height'), 10) : 0;
						$('#result_tab .tab-content').css('height', (ui.size.height - 12 - mini_tab_height) + 'px');
						/*
						$('.ui-resizable-handle').css('height') = "12px"
						$('.result_tab_open_btn').css('height') = "53px" (removed)
						*/

						if (window.tutorial_editor && window.tutorial_editor.resize) {
								window.tutorial_editor.resize();
						}
					}
				});
			}
		
			$(document).on('click', '#btn_show_exam_notice', function() {
				var exam_notice_popup = $('#exam_notice_popup');
				var is_show = $('#exam_notice_popup').css('display') != 'none';
				var idx = parseInt($('#exam_notice_popup').attr('idx'), 10);

				if (!is_show) {
					self.get_exam_notice(function() {
						self.set_exam_notice_view('auto', 0, function() {
							exam_notice_popup.show();
						});
					});
				} else {
					self.set_exam_notice_view('auto', idx, function() {
						exam_notice_popup.hide();
					});
				}
			});

			$(document).on('click', '.btn_exam_notice_select', function() {
				var idx = parseInt($('#exam_notice_popup').attr('idx'), 10);

				if ($(this).hasClass('prev')) {
					if (idx > 1) {
						self.set_exam_notice_view(idx - 1, idx, function() {
						});
					}
				} else {
					if (idx < self.exam_notice_list.length) {
						self.set_exam_notice_view(idx + 1, idx, function() {
						});
					}
				}
			});

			$(document).on('click', '.btn_exam_notice_close', function() {
				var exam_notice_popup = $('#exam_notice_popup');
				var idx = parseInt($('#exam_notice_popup').attr('idx'), 10);
				
				self.set_exam_notice_view('auto', idx, function() {
					exam_notice_popup.hide();
				});
			});
		},

		init_tree: function() {
			var self = this;
			if (this.exam_data) {
				var converted_data = [];

				var exam_info = {
					text: '<span class="chapter">' + this.exam_data.title.replace(/</g, '&lt;').replace(/>/g, '&gt;') + '</span>',
					href: '#',
					nodes: []
				};

				if (this.exam_data.quizlist && this.exam_data.quizlist.length !== 0) {
					$.get('/quiz/get_label', {
						'exam_index': this.exam_index,
						'quizlist': this.exam_data.quizlist
					}, function(result) {
						self.init_stat(result);
						// exam_common.set_finale_quiz();
						
						if(result && result.length && typeof(result) !== 'string') {
							self.accessable_quiz_list = [];
							
							for(var j = 0; j < self.exam_data.quizlist.length; j++) {
								for (var i = 0; i < result.length; i++) {
									var item = result[i];
									
									if(item.index === self.exam_data.quizlist[j]) {
										var quiz_info = {
											// 'href': self.pathname + '/exam/' + btoa(self.exam_index) + '/quiz/' + btoa(item.index),
											'index': item.index
										};

										var state = 0;

										if (item.result_hidden) {
											if (item.last_submit_date) {
												state = 3;
											}
										} else {
											if (item.solved_count > 0) {
												if (item.solved_count == item.input_count) {
													state = 1;
												} else {
													state = 2;
												}
											} else {
												if (item.last_submit_date) {
													if (item.solved_count === 0 && item.input_count === 0) {
														state = 1;
													}
												}
											}
										}
										
										exam_common.set_finale_quiz({
											'type': 'add',
											'submitted': item.last_submit_date,
											'title': item.title,
											'index': item.index
										});

										quiz_info.text = [
											'<span class="lesson ', self.STATE_CLASS[state], ' move_quiz" quiz_href="', self.pathname + '/exam/' + btoa(self.exam_index) + '/quiz/' +btoa(item.index), '">',
												self.STATE_ICON[state],
												'<i class="fa fa-code"></i> ',
												item.title,
													[
														item.difficulty ? '<span class="info" data-toggle="tooltip" data-placement="left" title="' + localization.get_value('difficulty') + '"><i class="fa fa-star"></i> ' + item.difficulty + '</span>': '',
														item.score ? '<span class="info" data-toggle="tooltip" data-placement="left" title="' + localization.get_value('points') + '">' + item.score + localization.get_value('points') + '</span>': ''
													].join(''),
											'</span>'].join('');

										if (quiz_info.index == self.quiz_index) {
											quiz_info.state = {
												checked: true
											};
										}
										exam_info.nodes.push(quiz_info);

										self.push_to_list(item.index);
										// self.accessable_quiz_list.push({
										// 	'index': item.index
										// });
									}
								}
							}
						} else { // if fail to get label data, just make quiz list
							for(var i = 0; i < self.exam_data.datalist.length; i++) {
								var item = self.exam_data.datalist[i];

								var quiz_info = {
									// 'href': self.pathname + '/exam/' + btoa(self.exam_index) + '/quiz/' + btoa(item.index),
									'index': item.index
								};

								var state = 0;
								
								exam_common.set_finale_quiz({
									'type': 'add',
									'submitted': false,
									'title': item.title,
									'index': item.index
								});
								
								quiz_info.text = [
									'<span class="lesson ', self.STATE_CLASS[state], ' move_quiz" quiz_href="', self.pathname + '/exam/' + btoa(self.exam_index) + '/quiz/' +btoa(item.index), '">',
										self.STATE_ICON[state],
										'<i class="fa fa-code"></i> ',
										item.title,
									'</span>'].join('');

								if (quiz_info.index == self.quiz_index) {
									quiz_info.state = {
										checked: true
									};
								}
								exam_info.nodes.push(quiz_info);

								self.push_to_list(item.index);
								// self.accessable_quiz_list.push({
								// 	'index': item.index
								// });
							}
						}
						
						var normal_datalist = self.exam_data.normal_datalist;
						
						if (normal_datalist && normal_datalist.length !== 0) {
							var _quiz_index = normal_datalist[0].index;
							var quiz_info = {
								// 'href': self.pathname + '/exam/' + btoa(self.exam_index) + '/quiz/' +btoa(_quiz_index),
								'index':_quiz_index
							};

							quiz_info.text = [
								'<span class="lesson move_quiz" quiz_href="', self.pathname + '/exam/' + btoa(self.exam_index) + '/quiz/' +btoa(_quiz_index), '">',
									'<i></i><i class="fa fa-file-text-o"></i> ',
									localization.get_value('normal_type_quiz'),
								'</span>'].join('');

							if (_quiz_index == self.quiz_index) {
								quiz_info.state = {
									checked: true
								};
							}
							exam_info.nodes.push(quiz_info);

							self.push_to_list(_quiz_index);
							// self.accessable_quiz_list.push({
							// 	'index': _quiz_index
							// });
							
							normal_datalist.forEach(function (quiz) {
								exam_common.set_finale_quiz({
									'type': 'add',
									'submitted': quiz.last_submit_date,
									'title': quiz.title,
									'index': quiz.index
								});
							});
							
							exam_common.quiz_type = 'tutorial';
						}
						
						converted_data.push(exam_info);

						self.tree_container.treeview({
							levels: 2,
							data: converted_data,
							enableLinks: true,
							collapseIcon: 'glyphicon'
						});
						
						$('[data-toggle="tooltip"]').tooltip();
						
						$('.learnpage_curriculum_list_btn').removeClass('disabled');
						self.init_nav();
						
					});
				}
			}
		},
		
		init_stat: function(data) {
 			if (data && data.length) {
 				if ($('.q_submit_count').text() == $('.q_total_count').text()) {
 					$('.header_stat').addClass('all_submitted');
 					$('.fa-minus-circle').removeClass('fa-minus-circle').addClass('fa-check-circle');
 				}
 			}
		},

		init_nav: function() {
			var list = this.accessable_quiz_list;

			var prev_quiz = null;
			var next_quiz = null;

			for (var i = 0; i < list.length; i++) {
				if (this.quiz_index == list[i].index) {
					if (list[i - 1]) {
						prev_quiz = list[i - 1];
					}

					if (list[i + 1]) {
						next_quiz = list[i + 1];
					}
					break;
				}
			}

			if (prev_quiz) {
				$('.nav_prev')
					.removeClass('disabled')
					.attr('quiz_href', this.pathname + '/exam/' + btoa(this.exam_index) + '/quiz/' + btoa(prev_quiz.index));
			}

			if (next_quiz) {
				$('.nav_next')
					.removeClass('disabled')
					.attr('quiz_href', this.pathname + '/exam/' + btoa(this.exam_index) + '/quiz/' + btoa(next_quiz.index));
			}
		},

		init_socket: function() {
			var self = this;
			
			if (!this.socket) {
				this.socket = io('', {'transports': ['websocket', 'polling']});
			}
			
			this.socket.emit('entrance_to_exam', {
				'exam_index': this.exam_index,
				'user_id': this.user_id
			});
			
			this.socket.on('reconnect', function() {
				self.socket.emit('entrance_to_exam', {
					'exam_index': self.exam_index,
					'user_id': self.user_id
				});
			});

			this.socket.on('edited_exam_data', function(msg) {
				// exam_common.set_popover_text({
				// 	'exam_date': msg
				// });
				// self.exam_end_date = msg.end_date;
				// self.exam_allow_exceed_deadline = msg.allow_exceed_deadline;
				// self.exam_exceed_deadline_days = msg.exceed_deadline_days;
				exam_common.init_timer();
				
				if (new Date(exam_common.exam_end_date) > new Date()) {
  					is_end_exam = false;
  				} else {
  					is_end_exam = true;
 				}
				
				toast.show(localization.get_value('msg_changed_exam_time'), {
					'method': 'warning'
				});
			});
			
			this.socket.on('existing_socket_disconnect', function() {
				$(window).off('beforeunload');
				window.location.href = '/apply/test/' + btoa(self.lecture_index);
			});
		
			this.socket.on('show_exam_notice', function(data) {
				var idx = parseInt($('#exam_notice_popup').attr('idx'), 10);

				self.exam_notice_list = JSON.parse(data);

				self.set_exam_notice_view(self.exam_notice_list.length, 0, function() {
					$('#exam_notice_popup').show();
				});
			});
		},
	
		get_exam_notice: function(callback) {
			var self = this;
			$.get('/exam/notice', {
				'foreign_key': self.exam_index
			}, function(data) {
				if (data) {
					data = JSON.parse(data);
				}

				self.exam_notice_list = data;

				$('#exam_notice_popup').attr('idx', data.length);

				self.set_exam_notice_view('auto', 0, function() {
					if (callback && typeof callback == 'function') {
						callback();
					}
				});
			});
		},

		set_exam_notice_view: function(current_idx, prev_idx, callback) {
			if (current_idx == 'auto') {
				current_idx = parseInt($('#exam_notice_popup').attr('idx'), 10);
			}

			if (this.exam_notice_list.length > 1) {
				var post_date = new Date(this.exam_notice_list[current_idx - 1].post_date);
				$('.exam_notice_msg_title').html(this.exam_notice_list[current_idx - 1].title);
				$('.exam_notice_msg_post_date').html(post_date.getFullYear() + '-' + ('0' + (post_date.getMonth() + 1)).slice(-2) + '-' + ('0' + post_date.getDate()).slice(-2) + ' ' + ('0' + post_date.getHours()).slice(-2) + ':' + ('0' + post_date.getMinutes()).slice(-2) + ':' + ('0' + post_date.getSeconds()).slice(-2));
				$('.exam_notice_msg_contents').html(this.exam_notice_list[current_idx - 1].contents);
				$('#exam_notice_popup').attr('idx', current_idx);

				$('.btn_exam_notice_select').removeClass('disable');
				if (current_idx == 1) {
					$('.btn_exam_notice_select.prev').addClass('disable');
				} else if (current_idx == this.exam_notice_list.length) {
					$('.btn_exam_notice_select.next').addClass('disable');
				}
			} else if (this.exam_notice_list.length == 1) {
				var post_date = new Date(this.exam_notice_list[current_idx - 1].post_date);
				$('.exam_notice_msg_title').html(this.exam_notice_list[current_idx - 1].title);
				$('.exam_notice_msg_post_date').html(post_date.getFullYear() + '-' + ('0' + (post_date.getMonth() + 1)).slice(-2) + '-' + ('0' + post_date.getDate()).slice(-2) + ' ' + ('0' + post_date.getHours()).slice(-2) + ':' + ('0' + post_date.getMinutes()).slice(-2) + ':' + ('0' + post_date.getSeconds()).slice(-2));
				$('.exam_notice_msg_contents').html(this.exam_notice_list[current_idx - 1].contents);
				$('#exam_notice_popup').attr('idx', current_idx);

				$('.btn_exam_notice_select').addClass('disable');
			} else {
				$('.exam_notice_msg_contents').html('<div style="text-align: center;">' + localization.get_value('no_exam_notice') + '<div>');

				$('.btn_exam_notice_select').addClass('disable');
			}

			var read_list = localStorage.getItem('grm_edu_exam_notice_read_list');

			if (read_list) {
				read_list = JSON.parse(read_list);
			} else {
				read_list = {};
			}

			if (!read_list[user_id]) {
				read_list[user_id] = {};
			}

			if (!read_list[user_id][this.exam_index]) {
				read_list[user_id][this.exam_index] = [];
			}

			var viewed = false;

			if (this.exam_notice_list.length == 0) {
				viewed = true;
			} else if (read_list[user_id][this.exam_index].indexOf(this.exam_notice_list[current_idx - 1]._id) > -1) {
				viewed = true;
			}

			if (viewed) {
				$('#title_exam_notice_unread_mark').hide();
			} else {
				$('#title_exam_notice_unread_mark').show();
			}

			if (prev_idx) {
				if (read_list[user_id][this.exam_index].indexOf(this.exam_notice_list[prev_idx - 1]._id) == -1) {
					read_list[user_id][this.exam_index].push(this.exam_notice_list[prev_idx - 1]._id);
				}
			}

			if (read_list[user_id][this.exam_index].length == this.exam_notice_list.length) {
				$('#header_exam_notice_unread_mark').hide();
			} else {
				$('#header_exam_notice_unread_mark').show();
				$('#exam_notice_popup').show();
			}

			localStorage.setItem('grm_edu_exam_notice_read_list', JSON.stringify(read_list));

			if (callback && typeof callback == 'function') {
				callback();
			}
		},

		push_to_list: function(index) {
			var _list = this.accessable_quiz_list;
			var already_in = false;

			for (var i = 0 ; i < _list.length; i++) {
				if (_list[i].index == index) {
					already_in = true;
					break;
				}
			}

			if (!already_in) {
				this.accessable_quiz_list.push({
					index: index
				});
			}
		}
	};

	return menu;
});