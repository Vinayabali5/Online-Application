(function() {
    'use strict';

    describe('Qualification', function() {
        var $httpBackend;
        var Qualification;

        var mockConfig = {
            api: ''
        };
        var qualificationData = [{
                title: 'GCSE Maths',
                level: 2
            },
            {
                title: 'GCSE English',
                level: 2
            },
        ];

        beforeEach(function() {
            jasmine.addCustomEqualityTester(angular.equals);
        });

        beforeEach(module('oas.service.qualification', {
            CONFIG: mockConfig
        }));

        beforeEach(inject(function(_$httpBackend_, _Qualification_) {
            $httpBackend = _$httpBackend_;
            $httpBackend.whenGET(mockConfig.api + '/api/lookup/qualifications').respond(200, qualificationData);
            Qualification = _Qualification_;
        }));

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        it('should fetch qualification data from the API endpoint', function() {
            var qualifications = [];
            Qualification.query().then(function(res) {
                qualifications = res.data;
            });
            expect(qualifications).toEqual([]);
            $httpBackend.expectGET(mockConfig.api + '/api/lookup/qualifications').respond(qualificationData);
            $httpBackend.flush();
            expect(qualifications).toEqual(qualificationData);
        });

    });

})();
