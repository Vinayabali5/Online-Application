/**
 * This is the configuration of the application initialised on launch.
 */
(function() {

    angular
        .module('oas')
        .config(ConfirueInterceptors)
        // .run(LoadStateVisualiser)
        .controller('OASController', OASController);

    ConfirueInterceptors.$inject = ['$httpProvider'];
    // LoadStateVisualiser.$inject = ['$uiRouter', 'CONFIG'];
    OASController.$inject = ['$scope'];

    function ConfirueInterceptors($httpProvider) {
        $httpProvider.interceptors.push('authInterceptor');
    }

    // function LoadStateVisualiser($uiRouter, CONFIG) {
    //     if (CONFIG.debug == true) {
    //         var vis = window['ui-router-visualizer'];
    //         vis.visualizer($uiRouter);
    //     }
    // }

    function OASController($scope) {
        $scope.defaultNgModelOptions = {
            allowInvalid: true
        };
    }



})();
