(function() {
    'use strict';

    describe('School', function() {
        var $httpBackend;
        var School;

        var mockConfig = {
            api: ''
        };
        var schoolData = [{
                name: 'Oakwood'
            },
            {
                name: 'Reigate School'
            },
            {
                name: 'DeStafford'
            },
        ];

        beforeEach(function() {
            jasmine.addCustomEqualityTester(angular.equals);
        });

        beforeEach(module('oas.service.school', {
            CONFIG: mockConfig
        }));

        beforeEach(inject(function(_$httpBackend_, _School_) {
            $httpBackend = _$httpBackend_;
            $httpBackend.whenGET(mockConfig.api + '/api/lookup/schools').respond(200, schoolData);
            School = _School_;
        }));

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        it('should fetch school data from the API endpoint', function() {
            var schools = [];
            School.query().then(function(res) {
                schools = res.data;
            });
            expect(schools).toEqual([]);
            $httpBackend.expectGET(mockConfig.api + '/api/lookup/schools').respond(schoolData);
            $httpBackend.flush();
            expect(schools).toEqual(schoolData);
        });

    });

})();
