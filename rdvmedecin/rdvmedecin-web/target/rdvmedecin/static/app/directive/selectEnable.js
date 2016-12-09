App.directive("selectEnable", [ "$timeout", function($timeout) {
	return {
		link : function(scope, element, attrs) {
			$timeout(function() {
				var selectpicker = $('.selectpicker');
				selectpicker.selectpicker();
			});
		}
	};
} ]);