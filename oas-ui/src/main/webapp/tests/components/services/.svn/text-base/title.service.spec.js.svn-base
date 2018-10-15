(function() {
    'use strict';

    describe('Title', function() {
        var $httpBackend;
        var Title;

        var mockConfig = {
            api: ''
        };
        var titleData = [{
                name: 'Mr'
            },
            {
                name: 'Mrs'
            },
        ];

        beforeEach(function() {
            jasmine.addCustomEqualityTester(angular.equals);
        });

        beforeEach(module('oas.service.title', {
            CONFIG: mockConfig
        }));

        beforeEach(inject(function(_$httpBackend_, _Title_) {
            $httpBackend = _$httpBackend_;
            $httpBackend.whenGET(mockConfig.api + '/api/lookup/titles').respond(200, titleData);
            Title = _Title_;
        }));

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        it('should fetch title data from the API endpoint', function() {
            var titles = [];
            Title.query().then(function(res) {
                titles = res.data;
            });
            expect(titles).toEqual([]);
            $httpBackend.expectGET(mockConfig.api + '/api/lookup/titles').respond(titleData);
            $httpBackend.flush();
            expect(titles).toEqual(titleData);
        });

    });

})();
