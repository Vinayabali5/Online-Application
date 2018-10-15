/**
 * This is an AngularJS filter that when used on a field will check to see if the fields is none, null or undefined. If
 * the data in the fields is any of these values the text 'No Data' will be displayed.
 *
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y024]
 *
 * @type filter
 */
(function() {
    angular
        .module('oas.filter.none', [])
        .filter('none', noneFilter);

    function noneFilter() {
        return function(data, length, end) {
            if (data === null || data === undefined || data === '') {
                return 'None';
            }
            return data;
        };
    }
})();
