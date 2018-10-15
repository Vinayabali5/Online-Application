(function() {
    angular
        .module('oas.user-registration')
        .config(UserRegistrationRouteConfiguration);

    UserRegistrationRouteConfiguration.$inject = ['$stateProvider'];

    function UserRegistrationRouteConfiguration($stateProvider) {
        var registrationState = {
            abstract: true,
            name: 'registration',
            parent: 'site',
            url: '/register',
            views: {
                "content@": {
                    templateUrl: 'js/modules/user-registration/views/layout.html',
                },
            }
        };

        var registrationNewUserState = {
            name: 'registration.newuser',
            url: '/',
            views: {
                "stage-info": {
                    template: '<h1>New User Account</h1><p>Before you can begin your application we need to create a user account for you. Please fill in the details below help use register a user account for your application.</p>',
                },
                "stage": {
                    templateUrl: 'js/modules/user-registration/views/new-user.html',
                    controller: 'UserRegistrationController',
                    controllerAs: 'ctrl',
                },
            }
        };

        var registrationConfirmEmailMessageState = {
            name: 'registration.confirmemail',
            url: '/emailsent',
            views: {
                "stage": {
                    templateUrl: 'js/modules/user-registration/views/email-sent.html',
                    controller: 'UserRegistrationController',
                    controllerAs: 'ctrl',
                },
            }
        };

        var registrationConfirmationState = {
            name: 'registration.confirm',
            url: '/confirm/{confirmationCode}',
            resolve: {
                confirmationInfo: function($stateParams, UserRegistrationService) {
                    return UserRegistrationService.loadConfirmation($stateParams.confirmationCode);
                }
            },
            views: {
                "stage": {
                    templateUrl: 'js/modules/user-registration/views/registration-confirmation.html',
                    controller: 'UserRegistrationConfirmationController',
                    controllerAs: 'ctrl',
                },
            }
        };

        $stateProvider.state(registrationState);
        $stateProvider.state(registrationNewUserState);
        $stateProvider.state(registrationConfirmEmailMessageState);
        $stateProvider.state(registrationConfirmationState);
    }
})();
