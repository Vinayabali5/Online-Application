(function() {
    'use strict';

    describe('Institution', function() {
        var $httpBackend;
        var Institution;

        var mockConfig = {
            api: ''
        };
        var institutionData = [{
                name: 'Reigate College'
            },
            {
                name: 'East Surrey College'
            },
        ];

        beforeEach(function() {
            jasmine.addCustomEqualityTester(angular.equals);
        });

        beforeEach(module('oas.service.institution', {
            CONFIG: mockConfig
        }));

        beforeEach(inject(function(_$httpBackend_, _Institution_) {
            $httpBackend = _$httpBackend_;
            $httpBackend.whenGET(mockConfig.api + '/api/institutions').respond(200, institutionData);
            Institution = _Institution_;
        }));

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        it('should fetch institution data from the API endpoint', function() {
            var institutions = [];
            Institution.query().then(function(res) {
                institutions = res.data;
            });
            expect(institutions).toEqual([]);
            $httpBackend.expectGET(mockConfig.api + '/api/institutions').respond(institutionData);
            $httpBackend.flush();
            expect(institutions).toEqual(institutionData);
        });

    });

})();
