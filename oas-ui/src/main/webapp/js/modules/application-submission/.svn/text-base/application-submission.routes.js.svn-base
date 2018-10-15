(function() {
    angular
        .module('oas.application-submission')
        .config(OASApplicationSubmissionRouteConfiguration);

    OASApplicationSubmissionRouteConfiguration.$inject = ['$stateProvider', '$urlRouterProvider'];

    function OASApplicationSubmissionRouteConfiguration($stateProvider) {

        var applicationSubmission = {
            name: 'application-submission',
            parent: 'site',
            abstract: true,
            url: '/submission',
            views: {
                "content@": {
                    controller: 'ApplicationSubmissionController',
                },
            },
            resolve: {},
        };

        var applicationSubmissionInstitutionSelection = {
            name: 'application-submission.institution',
            url: '/institution',
            views: {
                "content@": {
                    templateUrl: 'js/modules/application-submission/views/institution-selection.html',
                    controller: 'ApplicationSubmissionController'
                },
                "footer@": {
                    templateUrl: 'js/modules/application-submission/views/footer.html',
                    controller: 'ApplicationSubmissionController',
                }
            },
            resolve: {
                institutions: function(Institution) {
                    return Institution.query();
                },
                // submissions: function(Submission) {
                //     return {};
                // }
            }

        };

        $stateProvider.state(applicationSubmission);
        $stateProvider.state(applicationSubmissionInstitutionSelection);

    }
})();
