(function() {
    'use strict';

    describe('ContactType', function() {
        var $httpBackend;
        var ContactType;

        var mockConfig = {
            api: ''
        };
        var contactTypeData = [{
                name: 'Mother'
            },
            {
                name: 'Father'
            },
        ];

        beforeEach(function() {
            jasmine.addCustomEqualityTester(angular.equals);
        });

        beforeEach(module('oas.service.contact-type', {
            CONFIG: mockConfig
        }));

        beforeEach(inject(function(_$httpBackend_, _ContactType_) {
            $httpBackend = _$httpBackend_;
            $httpBackend.whenGET(mockConfig.api + '/api/lookup/contact-types').respond(200, contactTypeData);
            ContactType = _ContactType_;
        }));

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        it('should fetch contactType data from the API endpoint', function() {
            var contactTypes = [];
            ContactType.query().then(function(res) {
                contactTypes = res.data;
            });
            expect(contactTypes).toEqual([]);
            $httpBackend.expectGET(mockConfig.api + '/api/lookup/contact-types').respond(contactTypeData);
            $httpBackend.flush();
            expect(contactTypes).toEqual(contactTypeData);
        });

    });

})();
