(function() {
    'use strict';

    describe('ApplicationForm', function() {
        var $httpBackend;
        var ApplicationForm;

        var mockConfig = {
            api: ''
        };
        var applicationFormStatusData = {
            complete: false
        };
        var applicationFormData = {
            surname: 'Smith',
            firstName: 'John'
        };

        beforeEach(function() {
            jasmine.addCustomEqualityTester(angular.equals);
        });

        beforeEach(module('oas.service.application-form', {
            CONFIG: mockConfig
        }));

        beforeEach(inject(function(_$httpBackend_, _ApplicationForm_) {
            $httpBackend = _$httpBackend_;
            $httpBackend.whenGET(mockConfig.api + '/api/application').respond(200, applicationFormData);
            $httpBackend.whenGET(mockConfig.api + '/api/application/status').respond(200, applicationFormStatusData);
            $httpBackend.whenPUT(mockConfig.api + '/api/application').respond(200, applicationFormStatusData);
            ApplicationForm = _ApplicationForm_;
        }));

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        it('should fetch the users application form status data from the API endpoint', function() {
            var applicationFormStatus = {};
            ApplicationForm.status().then(function(res) {
                applicationFormStatus = res.data;
            });
            expect(applicationFormStatus).toEqual({});
            $httpBackend.expectGET(mockConfig.api + '/api/application/status').respond(applicationFormStatusData);
            $httpBackend.flush();
            expect(applicationFormStatus).toEqual(applicationFormStatusData);
        });

        it('should fetch the users application form data from the API endpoint', function() {
            var applicationForm = {};
            ApplicationForm.loadApplication().then(function(res) {
                applicationForm = res.data;
            });
            expect(applicationForm).toEqual({});
            $httpBackend.expectGET(mockConfig.api + '/api/application').respond(applicationFormData);
            $httpBackend.flush();
            expect(applicationForm).toEqual(applicationFormData);
        });

        it('should send the users application form data to the API endpoint', function() {
            var applicationForm = {};
            ApplicationForm.saveApplication(applicationFormData).then(function(res) {
                applicationForm = res.data;
            });
            expect(applicationForm).toEqual({});
            $httpBackend.expectPUT(mockConfig.api + '/api/application', applicationFormData).respond(applicationFormData);
            $httpBackend.flush();
            expect(applicationForm).toEqual(applicationFormData);
        });

    });

})();
