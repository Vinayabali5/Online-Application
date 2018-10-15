/**
 * This is the factory definition for the ContactType Data Service. This defines how to handle data about ContactTypeService objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('oas.service.contact-type', ['oas.config'])
        .factory('ContactType', contactTypeFactory);

    contactTypeFactory.$inject = ['$http', 'CONFIG'];

    function contactTypeFactory($http, CONFIG) {
        var url = CONFIG.api + '/api/lookup/contact-types';
        var service = {};

        // Public Interface

        service.query = getAll;

        return service;

        // Private Interface

        /**
         * This method is used to retrieve all the ContactType from the API collection.
         *
         * @return {Array} An array of ContactType objects.
         */
        function getAll() {
            return $http.get(url);
        }

    }

})();
