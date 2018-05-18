var notice = {
	init: function() {
		var self = this;

		this.title = "";
		this.image_url = "";

		this.panel = $('#dlg_alert');

		// this.image_url = "images/goorm.core.dialog/dialog_alert.png";
		this.panel.find(".modal-footer button:last-child").last().click(function() {
			self.panel.modal('hide');
		});

		// move to Center
		//
		this.panel.on("show.bs.modal", function() {
			setTimeout(function() {
				self.panel.css('top', '0px');

				var container = self.panel.find('.modal-dialog');

				var window_height = $(window).height();
				var container_height = container.height();

				if (window_height > container_height) {
					container.css('margin-top', ((window_height - container_height) / 2) + 'px');
				} else {
					container.css('margin-top', '10px');
				}
			}, 200); // fade animation: 0.15s -> 150
		});

		return this;
	},

	show: function(message, options) {
		if (!options) {
			options = {};
		}

		if (!options.theme) {
			options.theme = 'error';
		}
		
		var is_localization = false;
		if (typeof localization !== "undefined") {
			is_localization = true;
		}

		switch(options.theme) {
			case 'error':
				this.title = is_localization ? localization.get_value('error') : 'Error';
				this.image_url = '/images/notice/error.png';
				break;

			case 'warning':
				this.title = is_localization ? localization.get_value('warning') : 'Warning';
				this.image_url = '/images/notice/warning.png';
				break;

			case 'info':
				this.title = is_localization ? localization.get_value('info') : 'Info';
				this.image_url = '/images/notice/info.png';
				break;

			case 'success':
				this.title = is_localization ? localization.get_value('success') : 'Success';
				this.image_url = '/images/notice/success.png';
				break;
		}

		this.message = message;

		var panelContainer_bd = this.panel.find("#alert_content_container");

		this.panel.find('.modal-title').html(this.title);

		panelContainer_bd.empty();
		panelContainer_bd.append("<div class='alert_content_div col-md-9 col-xs-9'>" + this.message + "</div>").prepend("<div class='alert_image_div col-md-3 col-xs-3'><img src='" + this.image_url + "' style='width: 48px; height: 48px;' /></div>");

		this.panel.modal('show');
	}
};

if (typeof(define) === 'undefined') {
	window.confirmation = notice;
} else {
	define(function(){
		var widgets = {};
		
		widgets.notice = function() {
			this.panel = null;
		};

		widgets.notice.prototype = notice;

		return widgets.notice;
	});	
}