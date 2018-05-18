var log_connect = {
	lecture_index: null,
	lesson_index: null,
	socket: null,
	
	'load': function(options) {
		if (options) {
			this.lecture_index = options.lecture_index;
			this.lesson_index = options.lesson_index;
			this.socket = options.socket;
		}
		this.edu_connect();
		this.init_event();
	},

	edu_connect: function() {
		if (!this.socket) {
			this.socket = io('', {'transports': ['websocket', 'polling']});
		}
		this.socket.emit('edu_connect', {url: window.location.href});
	},
	
	init_event: function() {
		var self = this;
		$('#out_link_btn').click(function() {
			var url = $('#out_link_btn').parent().attr('href');
			$.post('/link/out', {
				lecture_index: self.lecture_index,
				lesson_index: self.lesson_index,
				extern_url: url,
				url: window.location.href
			}, function(result) {
			});
		});
	}
};
