(function() {

    'use strict';

    describe('authInterceptor', function() {
        var authInterceptor;

        var mockPromise = {};
        var mockState = {
            go: function() {}
        };
        var mockQ = {
            reject: function() {}
        };

        beforeEach(function() {
            spyOn(mockState, 'go');
            spyOn(mockQ, 'reject');
        });

        beforeEach(module('oas.interceptor.auth', {
            $q: mockQ,
            $state: mockState
        }));

        beforeEach(inject(function(_authInterceptor_) {
            authInterceptor = _authInterceptor_;
        }));

        it('should have an error method', function() {
            expect(authInterceptor.responseError).toBeDefined();
            expect(angular.isFunction(authInterceptor.responseError)).toBe(true);
        });

        it('should redirect to login state on response error status 401', inject(function($q, $state) {
            expect($state.go).not.toHaveBeenCalled();
            authInterceptor.responseError({
                status: 401
            });
            expect($state.go).toHaveBeenCalledTimes(1);
            expect($state.go).toHaveBeenCalledWith('login');
            expect($q.reject).toHaveBeenCalledTimes(1);
        }));

        it('should reject promise on response error status other than 401', inject(function($q, $state) {
            authInterceptor.responseError({
                status: 404
            });
            expect($state.go).not.toHaveBeenCalled();
            expect($q.reject).toHaveBeenCalled();
            expect($q.reject).toHaveBeenCalledTimes(1);
        }));


    });

})();
