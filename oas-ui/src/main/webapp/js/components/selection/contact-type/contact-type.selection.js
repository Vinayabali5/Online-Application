(function() {
    angular
        .module('oas.selection.contact-type', [
            'oas.service.logger',
            'oas.service.contact-type',
        ])
        .directive('contactTypeSelection', ContactTypeSelectionDirective);

    ContactTypeSelectionDirective.$inject = ['Logger', 'ContactType'];

    function ContactTypeSelectionDirective(Logger, ContactType) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                readonly: '=?',
                ngModel: '='
            },
            link: function(scope, element, attrs) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: function(ContactType) {
                var vm = this;
                vm.contactTypes = [];

                ContactType.query().then(function(response) {
                    vm.contactTypes = response.data;
                }, function(response) {
                    Logger.error("Error Retrieving Contact Type");
                });
            },
            controllerAs: 'ctrl',
            templateUrl: 'js/components/selection/contact-type/contact-type.selection.html',

        };
    }
})();
