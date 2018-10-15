/**
 * This is the definition of the Online Applications main site features.
 */
(function() {

    angular.module('oas.site').controller('OASSiteNavigationController', OASSiteNavigationController);

    OASSiteNavigationController.$inject = ['$rootScope', '$scope', 'CONFIG', 'UIData'];

    function OASSiteNavigationController($rootScope, $scope, CONFIG, UIData) {
        // Public Interface

        $scope.showDropdownMenu = false;

        $scope.loggedIn = isLoggedIn();

        $scope.status = UIData.status;

        // Private Interface

        function isLoggedIn() {
            return $rootScope.globals.currentUser !== undefined;
        }

        $scope.$watch(function() {
            return $rootScope.globals.currentUser;
        }, function() {
            $scope.loggedIn = isLoggedIn();
        }, true);

        $scope.$watch(function() {
            return UIData.status;
        }, function() {
            $scope.status = UIData.status;
        }, true);



    }

})();
