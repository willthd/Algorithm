var v = '20171215_1';
// var cdn_url = '//statics.goorm.io/codingtest/v/' + v;
var cdn_url = '';

requirejs.config({
    baseUrl: cdn_url + '/modules',
	// baseUrl: "/modules",
    waitSeconds: 200,
	packages: [{
		name: "codemirror",
		location: cdn_url + "/libs/codemirror",
		main: "lib/codemirror"
	}, {
		name: 'summernote',
		location: cdn_url + '/libs/summernote',
		main: 'summernote.min'
	}],
    paths: {
        "jquery": cdn_url + "/libs/jquery/jquery-2.1.1.min",
        "jquery.form": cdn_url + "/libs/jquery/jquery.form",
        "jquery-ui": cdn_url + "/libs/jquery/jquery-ui.min",
		"datatables": "/libs/jquery/jquery.dataTables.bootstrap",
        "datatables.net": "/libs/jquery/jquery.dataTables.min",
        "datatables.natural-sort": "/libs/jquery/jquery.dataTables.natural-sort",
        "jquery.jpanelmenu": cdn_url + "/libs/jquery/jquery.jpanelmenu.min",
		"moment": cdn_url + "/libs/moment/moment-with-locales.min",
        "bootstrap": cdn_url + "/libs/bootstrap/js/bootstrap-edu.min",
        "bootstrap-tour": cdn_url + "/libs/bootstrap/js/bootstrap-tour",
		"bootstrap-datetimepicker": cdn_url + "/libs/bootstrap/js/bootstrap-datetimepicker.min",
		"bootstrap-tagsinput": cdn_url + "/libs/bootstrap/js/bootstrap-tagsinput.min",
		"bootstrap-treeview": cdn_url + "/libs/bootstrap-treeview/bootstrap-treeview.min",
		"bootstrap-treeview-raw": cdn_url + "/libs/bootstrap-treeview/bootstrap-treeview.raw",
		"bootstrap-select": cdn_url + "/libs/bootstrap/js/bootstrap-select.min",
		"bootstrap-colorpicker": cdn_url + "/libs/bootstrap/js/bootstrap-colorpicker.min",
		// "ckeditor": cdn_url + "/libs/ckeditor/ckeditor",
		// "chart": cdn_url + "/libs/chart/Chart.min",
		// "chart.horizontal": cdn_url + "/libs/chart/Chart.HorizontalBar",
		// "chart.stackedline": cdn_url + "/libs/chart/Chart.StackedLine",
		// "chart.stackedbar": cdn_url + "/libs/chart/Chart.StackedBar",
		"socket.io": "/socket.io/socket.io",
        "domReady": cdn_url + "/libs/domReady",
        "async": cdn_url + "/libs/async",
        "jstree": cdn_url + "/libs/jquery/jstree/jstree",
		"jquery.throttle.debounce": cdn_url + "/libs/jquery/jquery.throttle.debounce",
		// "codemirror": cdn_url + "/libs/codemirror/lib/codemirror",
        "ua-parser": cdn_url + "/libs/ua-parser/ua-parser.min",
		// "bootstrap-wizard": cdn_url + "/libs/bootstrap/js/jquery.bootstrap.wizard.min",
		// "summernote": cdn_url + "/libs/summernote/summernote",
		"marked": cdn_url + "/libs/marked",
		"toMarkdown": cdn_url + "/libs/to-markdown",
		"d3": cdn_url + "/libs/c3/d3.min",
		"c3": cdn_url + "/libs/c3/c3.min",
		"battle": "/robocode/battle",
		"toast": cdn_url + "/libs/Toastr/toastr.min",
		"clipboard": cdn_url + "/libs/clipboard.js/clipboard.min",
		"swfobject": cdn_url + "/libs/swfobject/swfobject",
		// "mathjax": cdn_url + "/libs/MathJax/MathJax",
		// "mathjax-config": cdn_url + "/libs/MathJax/config/TeX-MML-AM_SVG"
		"mathjax": "https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.1/MathJax.js?config=TeX-MML-AM_SVG"
    },
    shim: {
        "jquery.form": ["jquery"],
        "jquery-ui": ["jquery"],
        "datatables": ["jquery"],
        "datatables.net": ["jquery"],
        "datatables.natural-sort": ["jquery", "datatables.net"],
        "jquery.jpanelmenu": ["jquery"],
        "jstree": ["jquery"],
		"jquery.throttle.debounce": ["jquery"],
		"moment": ["jquery"],
        "bootstrap": ["jquery"],
        "bootstrap-tour": ["bootstrap"],
		"bootstrap-treeview-raw": ["bootstrap"],
		"bootstrap-datetimepicker": ["bootstrap"],
		// "bootstrap-wizard": ["bootstrap"],
		"bootstrap-tagsinput": ["bootstrap"],
		"bootstrap-select": ["jquery", "bootstrap"],
		"bootstrap-colorpicker": ["bootstrap"],
        // "codemirror": {
        //     "exports": "CodeMirror"
        // },
        "socket.io": {
            "exports": "io"
        },
        // "ckeditor": {
        //     'exports': 'CKEDITOR'
        // },
		// "chart.horizontal": ["chart"],
		// "chart.stackedline": ["chart"],
		// "chart.stackedbar": ["chart"],
		// "chart": {
		// 'exports': 'Chart'
		// },
		"summernote": ["jquery", "bootstrap"],
		"c3": ["d3"],
		// "mathjax": {
		// 	"init": function () {
		// 		MathJax.Hub.Config({
		// 			'tex2jax': {
		// 				'inlineMath': [["$","$"],["\\(","\\)"]]
		// 			},
		// 			'jax': ['output/SVG'],
		// 			'skipStartupTypeset': true	// we will typeset manually after contents is fully loaded
		// 		});
				
		// 		MathJax.Hub.Startup.onload();
				
		// 		return MathJax;
		// 	}
		// },
		// "mathjax-config": ["mathjax"]
    },
	urlArgs: '_v=' + v
});