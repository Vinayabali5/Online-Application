describe('NotSetFilter', function() {
    var $filter;

    beforeEach(function() {
        module('oas.filter.yes-no');

        inject(function(_$filter_) {
            $filter = _$filter_;
        });
    });

    it('should return the text "No data" when a null value is passed', function() {
        result = $filter('yesNo')(null);
        expect(result).toBe('No data');
    });

    it('should return the text "No data" when a undefined value is passed', function() {
        result = $filter('yesNo')(undefined);
        expect(result).toBe('No data');
    });

    it('should return the text "No data" when a blank string value is passed', function() {
        result = $filter('yesNo')('');
        expect(result).toBe('No data');
    });

    it('should return the text "Yes" if supplied a true value', function() {
        result = $filter('yesNo')(true);
        expect(result).toBe('Yes');
    });

    it('should return the text "No" if supplied a false value', function() {
        result = $filter('yesNo')(false);
        expect(result).toBe('No');
    });

});
