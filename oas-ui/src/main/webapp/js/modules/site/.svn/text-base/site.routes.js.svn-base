(function() {
    angular
        .module('oas.site')
        .config(OASSiteRouteConfiguration);

    OASSiteRouteConfiguration.$inject = ['$stateProvider', '$urlRouterProvider'];

    function OASSiteRouteConfiguration($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');


        var mainSiteState = {
            name: 'site',
            abstract: true,
            views: {
                "nav@": {
                    templateUrl: 'js/modules/site/views/nav.html',
                    controller: 'OASSiteNavigationController',
                    controllerAs: 'ctrl',
                },

            }
        };

        var homeState = {
            name: 'home',
            parent: 'site',
            url: '/',
            views: {
                "content@": {
                    templateUrl: 'js/modules/site/views/home.html',
                    // controller: 'OASSiteNavigationController',
                    // controllerAs: 'ctrl'
                },
            }
        };

        var loginState = {
            name: 'login',
            parent: 'site',
            url: '/login',
            views: {
                "content@": {
                    templateUrl: 'js/modules/site/views/login.html',
                    controller: 'OASSiteLoginController',
                    controllerAs: 'ctrl',
                },
            }
        };

        var logoutState = {
            name: 'logout',
            parent: 'site',
            url: '/login',
            views: {
                "content@": {
                    templateUrl: 'js/modules/site/views/login.html',
                    controller: function(AuthenticationService) {
                        AuthenticationService.clearCredentials();
                    },
                },
            }
        };

        $stateProvider.state(mainSiteState);
        $stateProvider.state(homeState);
        $stateProvider.state(loginState);
        $stateProvider.state(logoutState);
    }
})();
