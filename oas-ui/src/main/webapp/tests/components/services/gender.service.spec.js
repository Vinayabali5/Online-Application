(function() {
    'use strict';

    describe('Gender', function() {
        var $httpBackend;
        var Gender;

        var mockConfig = {
            api: ''
        };
        var genderData = [{
                name: 'Male'
            },
            {
                name: 'Femmale'
            },
        ];

        beforeEach(function() {
            jasmine.addCustomEqualityTester(angular.equals);
        });

        beforeEach(module('oas.service.gender', {
            CONFIG: mockConfig
        }));

        beforeEach(inject(function(_$httpBackend_, _Gender_) {
            $httpBackend = _$httpBackend_;
            $httpBackend.whenGET(mockConfig.api + '/api/lookup/genders').respond(200, genderData);
            Gender = _Gender_;
        }));

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        it('should fetch gender data from the API endpoint', function() {
            var genders = [];
            Gender.query().then(function(res) {
                genders = res.data;
            });
            expect(genders).toEqual([]);
            $httpBackend.expectGET(mockConfig.api + '/api/lookup/genders').respond(genderData);
            $httpBackend.flush();
            expect(genders).toEqual(genderData);
        });

    });

})();
