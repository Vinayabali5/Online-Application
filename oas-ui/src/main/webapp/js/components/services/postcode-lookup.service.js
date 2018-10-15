/**
 * This is the factory definition for the PostcodeLookup Data Service. This defines how to handle data about PostcodeLookup objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('oas.service.postcode-lookup', ['oas.config'])
        .factory('PostcodeLookup', postCodeFactory);

    postCodeFactory.$inject = ['$q', '$http', 'CONFIG'];

    function postCodeFactory($q, $http, CONFIG) {
        var url = CONFIG.api + '/api/postcodes';

        var factory = {
            search: search,
            retrieve: retrieve
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the PostcodeLookup from the API collection.
         * @param  {String} postcode The Unique Postcode to retrieve the address
         * @return {PostcodeLookup} An array of PostcodeLookup objects.
         */
        function search(postcode) {
            return $http.get(url + '/search/' + postcode).then(function(response) {
                if (response.data.length === 0) {
                    return $q.reject("No results found");
                }
                return response;
            });
        }

        /**
         * This method is used to retrieve an instance of a PostcodeLookup from the API collection.
         * @param  {int} id The Unique Id of the Postcode to retrieve the address
         * @return {PostcodeLookup} An PostcodeLookup object as identified by the id.
         */
        function retrieve(id) {
            return $http.get(url + '/retrieve/' + encodeURIComponent(id));
        }
    }

})();
