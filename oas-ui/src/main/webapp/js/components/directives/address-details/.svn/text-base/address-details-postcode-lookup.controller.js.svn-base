/**
 * This controller is used by the AddressEditorDirective.
 *
 * Applied Style: [Y001, Y002, Y010, Y022, Y023, Y024, Y032, Y033, Y034] *
 *
 */

(function() {

    angular
        .module('oas.directive.address-details')
        .controller('AddressDetailsPostcodeLookupDialogController', addressDetailsPostcodeDialogController);

    addressDetailsPostcodeDialogController.$inject = ['$rootScope', 'Logger', '$uibModalInstance', 'postcodeLookups', 'PostcodeLookup'];

    function addressDetailsPostcodeDialogController($rootScope, Logger, $uibModalInstance, postcodeLookups, PostcodeLookup) {
        var vm = this;
        vm.postcode = postcodeLookups.data;
        vm.selectedPostcodeId = null;
        vm.selectAddress = selectAddress;
        vm.clear = clear;

        function selectAddress() {
            Logger.log('AddressDetailsPostcodeLookupDialogController::select called');
            PostcodeLookup.retrieve(this.selectedPostcodeId).then(function(response) {
                $rootScope.$emit('address-selected', response.data);
                $uibModalInstance.close(response.data);
            });
        }

        function clear() {
            Logger.log('AddressDetailsPostcodeLookupDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
