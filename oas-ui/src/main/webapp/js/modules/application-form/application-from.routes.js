(function() {
    angular
        .module('oas.application-form')
        .config(OASApplicationFormRouteConfiguration);

    OASApplicationFormRouteConfiguration.$inject = ['$stateProvider', '$urlRouterProvider'];

    function OASApplicationFormRouteConfiguration($stateProvider, $urlRouterProvider) {

        var applicationForm = {
            name: 'application-form',
            parent: 'site',
            abstract: true,
            //url: '/application-form',

            views: {
                "content@": {
                    //         templateUrl: 'js/modules/application-form/views/application-form-status.html',
                    controller: 'ApplicationFormController',
                },
                "footer@": {
                    templateUrl: 'js/modules/application-form/views/footer.html',
                    controller: 'ApplicationFormController',
                }
            },
            resolve: {
                // applicationFormStatus: function(ApplicationForm) {
                //     return ApplicationForm.status();
                // },
                // applicationForm: function(ApplicationForm) {
                //     return ApplicationForm.loadApplication();
                // },
                uiData: function(UIData) {
                    return UIData.promise;
                }
            },
        };

        var applicationFormStatus = {
            name: 'application-form.status',
            url: '/status',
            views: {
                "content@": {
                    templateUrl: 'js/modules/application-form/views/application-form-status.html',
                    controller: 'ApplicationFormController',
                },
            },
            resolve: {},
        };

        var applicationFormPersonalDetails = {
            name: 'application-form.personal-details',
            url: '/personal-details',
            data: {
                nextState: 'application-form.education-details'
            },
            views: {
                "content@": {
                    templateUrl: 'js/modules/application-form/views/personal-details.html',
                    controller: 'ApplicationFormController',
                    // controllerAs: 'ctrl'
                },
            },
            resolve: {
                // TODO: check to see if the reloading of the application object is required at each child state. this may not
                // be beeded as the application data is probably held in the parent scope
                // applicationForm: function(ApplicationForm) {
                //     return ApplicationForm.loadApplication();
                // }
            }

        };

        var applicationFormEducationDetails = {
            name: 'application-form.education-details',
            url: '/education-details',
            data: {
                nextState: 'application-form.additional-details'
            },
            views: {
                "content@": {
                    templateUrl: 'js/modules/application-form/views/education-details.html',
                    controller: 'ApplicationFormController'
                },
            },
            resolve: {
                // TODO: check to see if the reloading of the application object is required at each child state. this may not
                // be beeded as the application data is probably held in the parent scope
                // applicationForm: function(ApplicationForm) {
                //     return ApplicationForm.loadApplication();
                // }
            }

        };

        var applicationFormAdditionalDetails = {
            name: 'application-form.additional-details',
            url: '/additional-details',
            data: {
                nextState: 'application-form.status'
            },
            views: {
                "content@": {
                    templateUrl: 'js/modules/application-form/views/additional-details.html',
                    controller: 'ApplicationFormController'
                },
            },
            resolve: {
                // TODO: check to see if the reloading of the application object is required at each child state. this may not
                // be beeded as the application data is probably held in the parent scope
                // applicationForm: function(ApplicationForm) {
                //     return ApplicationForm.loadApplication();
                // }
            }

        };

        $stateProvider.state(applicationForm);
        $stateProvider.state(applicationFormStatus);
        $stateProvider.state(applicationFormPersonalDetails);
        $stateProvider.state(applicationFormEducationDetails);
        $stateProvider.state(applicationFormAdditionalDetails);

    }
})();
