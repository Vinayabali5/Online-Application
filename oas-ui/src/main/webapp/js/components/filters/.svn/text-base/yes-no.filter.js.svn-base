/**
 * This is the definition of the Online Applications main site features.
 */
(function() {

    angular
        .module('oas.filter.yes-no', [])
        .filter('yesNo', function() {
            return function(text, length, end) {
                // if (text === null || text === undefined) {
                //     return 'No data';
                // }
                if (text === true) {
                    return 'Yes';
                } else if (text === false) {
                    return 'No';
                } else {
                    return 'No data';
                }
            };
        });

})();
