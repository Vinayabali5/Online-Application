/**
 * This is the definition of the Online Applications main site features.
 */
(function() {
    angular
        .module('oas.config', [])
        .factory('CONFIG', Configuration);

    Configuration.$inject = ['$http'];

    function Configuration($http) {

        var service = {};

        // Public Interface

        service.api = 'http://localhost:9901';
        service.debug = true;
        service.options = {
            datepicker: {
                format: 'dd/MM/yyyy',
                datepickerMode: 'day',
                datepickerConfig: 'dd/MM/yyyy',
                formatDay: 'dd',
                formatMonth: 'MM',
                formatYear: 'yyyy',
                startingDay: 1
            },
            monthpicker: {
                datepickerMode: 'month',
                minMode: 'month',
                formatMonth: 'MMMM',
                formatYear: 'yyyy'
            }
        };
        service.validation = {
            simplePostcodePattern: '[A-Za-z]{1,2}[0-9][0-9A-Za-z]? ?[0-9][A-Za-z]{2}',
            fullPostcodePattern: '(GIR 0AA)|((([ABCDEFGHIJKLMNOPRSTUWYZ][0-9][0-9]?)|(([ABCDEFGHIJKLMNOPRSTUWYZ][ABCDEFGHKLMNOPQRSTUVWXY][0-9][0-9]?)|(([ABCDEFGHIJKLMNOPRSTUWYZ][0-9][ABCDEFGHJKSTUW])|([ABCDEFGHIJKLMNOPRSTUWYZ][ABCDEFGHKLMNOPQRSTUVWXY][0-9][ABEHMNPRVWXY])))) [0-9][ABDEFGHJLNPQRSTUWXYZ]{2})',
        };
        service.defaults = {
            predictedGrade: {
                yearOfExamination: 2018
            }
        };

        loadConfiguration();

        return service;


        // Private Interface

        function loadConfiguration() {
            $http.get('/config.json').then(function(response) {
                service.api = response.data.api !== undefined ? response.data.api : service.api;
                service.debug = response.data.debug !== undefined ? response.data.debug : service.debug;
            });
        }

    }
})();
