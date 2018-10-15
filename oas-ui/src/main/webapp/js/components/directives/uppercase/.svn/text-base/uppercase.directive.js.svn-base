(function() {
    angular
        .module('oas.directive.uppercase', [])
        .directive('uppercase', uppercase);

    uppercase.$inject = [];

    function uppercase() {
        return {
            restrict: 'A',
            require: 'ngModel',
            link: function(scope, element, attrs, modelCtrl) {
                var uppercase = function(inputValue) {
                    if (inputValue !== undefined) {
                        var uppercased = inputValue.toUpperCase();
                        return uppercased;
                    }
                };

                element.css("text-transform", "uppercase");
                modelCtrl.$parsers.push(uppercase);
                uppercase(scope[attrs.ngModel]);
            }
        };
    }

})();
