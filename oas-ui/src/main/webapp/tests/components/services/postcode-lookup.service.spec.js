(function() {
    'use strict';

    describe('PostcodeLookup', function() {
        var $httpBackend;
        var PostcodeLookup;

        var mockConfig = {
            api: ''
        };
        var postcode = 'RH20SD';
        var postcodeData = [{
                id: 'RH2|TEST1',
                postcode: postcode
            },
            {
                id: 'RH2|TEST2',
                postcode: postcode
            },
        ];

        beforeEach(function() {
            jasmine.addCustomEqualityTester(angular.equals);
        });

        beforeEach(module('oas.service.postcode-lookup', {
            CONFIG: mockConfig
        }));

        beforeEach(inject(function(_$httpBackend_, _PostcodeLookup_) {
            $httpBackend = _$httpBackend_;
            $httpBackend.whenGET(mockConfig.api + '/api/postcodes/search/' + postcode).respond(200, postcodeData);
            $httpBackend.whenGET(mockConfig.api + '/api/postcodes/retrieve/' + encodeURIComponent(postcodeData[0].id)).respond(200, postcodeData[0]);
            PostcodeLookup = _PostcodeLookup_;
        }));

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        it('should fetch postcode data from the API endpoint when the search method is called', function() {
            var postcodes = [];
            PostcodeLookup.search(postcode).then(function(res) {
                postcodes = res.data;
            });
            expect(postcodes).toEqual([]);
            $httpBackend.expectGET(mockConfig.api + '/api/postcodes/search/' + postcode).respond(postcodeData);
            $httpBackend.flush();
            expect(postcodes).toEqual(postcodeData);
        });

        it('should fetch postcode data from the API endpoint when the retrieve method is called', function() {
            var postcodes = [];
            PostcodeLookup.retrieve(postcodeData[0].id).then(function(res) {
                postcodes = res.data;
            });
            expect(postcodes).toEqual([]);
            var encodedId = encodeURIComponent(postcodeData[0].id);
            $httpBackend.expectGET(mockConfig.api + '/api/postcodes/retrieve/' + encodedId).respond(postcodeData);
            $httpBackend.flush();
            expect(postcodes).toEqual(postcodeData);
        });

    });

})();
