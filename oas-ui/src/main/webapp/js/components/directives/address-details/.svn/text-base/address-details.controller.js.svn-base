(function() {
    angular
        .module('oas.directive.address-details')
        .controller('AddressDetailsController', AddressDetailsController);

    AddressDetailsController.$inject = ['$scope', '$uibModal', 'Logger', 'CONFIG'];

    function AddressDetailsController($scope, $uibModal, Logger, CONFIG) {
        var vm = this;

        $scope.postcodePattern = CONFIG.validation.simplePostcodePattern;

        $scope.label = $scope.label === undefined ? 'Address Details' : $scope.label;

        $scope.postcodeLookup = postcodeLookup;

        initialise();

        function postcodeLookup(postcode) {
            Logger.log('Postcode Lookup: ' + postcode);
            vm.modalOptions = {
                templateUrl: 'js/components/directives/address-details/address-details-postcode-lookup-dialog.html',
                controller: 'AddressDetailsPostcodeLookupDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    postcodeLookups: function(PostcodeLookup) {
                        return PostcodeLookup.search(postcode).then(function(response) {
                            return response;
                        }, function(response) {
                            Logger.error(response.data.message, true);
                        });
                    }
                }
            };
            $uibModal.open(vm.modalOptions).result.then(function(response) {
                $scope.address.line1 = response.line1;
                $scope.address.line2 = response.line2;
                $scope.address.line3 = response.line3;
                $scope.address.line4 = response.line4;
                $scope.address.line5 = response.line5;
                $scope.address.town = response.town;
                $scope.address.county = response.county;
                $scope.address.postcode = response.postcode;
                Logger.log(response);
            });
        }

        function initialise() {
            if (!$scope.isRequired || $scope.isRequired == undefined) {
                $scope.isRequired = false;
            }
        }

    }
})();
