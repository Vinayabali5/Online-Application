(function() {
    'use strict';

    describe('Ethnicity', function() {
        var $httpBackend;
        var Ethnicity;

        var mockConfig = {
            api: ''
        };
        var ethnicityData = [{
                name: 'Ethnciity 1'
            },
            {
                name: 'Ethnciity 2'
            },
        ];

        beforeEach(function() {
            jasmine.addCustomEqualityTester(angular.equals);
        });

        beforeEach(module('oas.service.ethnicity', {
            CONFIG: mockConfig
        }));

        beforeEach(inject(function(_$httpBackend_, _Ethnicity_) {
            $httpBackend = _$httpBackend_;
            $httpBackend.whenGET(mockConfig.api + '/api/lookup/ethnicities').respond(200, ethnicityData);
            Ethnicity = _Ethnicity_;
        }));

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        it('should fetch ethnicity data from the API endpoint', function() {
            var ethnicities = [];
            Ethnicity.query().then(function(res) {
                ethnicities = res.data;
            });
            expect(ethnicities).toEqual([]);
            $httpBackend.expectGET(mockConfig.api + '/api/lookup/ethnicities').respond(ethnicityData);
            $httpBackend.flush();
            expect(ethnicities).toEqual(ethnicityData);
        });

    });

})();
