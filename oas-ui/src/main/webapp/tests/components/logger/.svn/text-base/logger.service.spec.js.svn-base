(function() {
    'use strict';

    describe('Logger', function() {
        var Logger;
        var message = 'Test Message';
        var $log;

        beforeEach(module('oas.service.logger', {
            Notification: jasmine.createSpy('Notification'),
            CONFIG: {}
        }));

        beforeEach(inject(function(_$log_, _Logger_) {
            $log = _$log_;
            Logger = _Logger_;
        }));

        it('should have a log method', function() {
            expect(Logger.log).toBeDefined();
            expect(angular.isFunction(Logger.log)).toBe(true);
        });

        it('should have a warn method', function() {
            expect(Logger.warn).toBeDefined();
            expect(angular.isFunction(Logger.warn)).toBe(true);
        });

        it('should have an error method', function() {
            expect(Logger.error).toBeDefined();
            expect(angular.isFunction(Logger.error)).toBe(true);
        });

        it('should have a debug method', function() {
            expect(Logger.debug).toBeDefined();
            expect(angular.isFunction(Logger.debug)).toBe(true);
        });

        it('should log a message to the info console when the log method is called', inject(function(Notification) {
            Logger.log(message);
            expect($log.info.logs[0]).toContain(message);
        }));

        it('should log a message to the info console and call the Notification when the log method is called', inject(function(Notification) {
            Logger.log(message, true);
            expect($log.info.logs[0]).toContain(message);
            expect(Notification).toHaveBeenCalledWith(message);
        }));

        it('should log a message to the warn console when the warn method is called', inject(function(Notification) {
            Logger.warn(message);
            expect($log.warn.logs[0]).toContain(message);
        }));

        it('should log a message to the warn console and call the Notification when the warn method is called', inject(function(Notification) {
            Logger.warn(message, true);
            expect($log.warn.logs[0]).toContain(message);
            expect(Notification).toHaveBeenCalledWith(message, 'warning');
        }));

        it('should log a message to the error console when the error method is called', inject(function(Notification) {
            Logger.error(message);
            expect($log.error.logs[0]).toContain(message);
        }));

        it('should log a message to the error console and call the Notification when the error method is called', inject(function(Notification) {
            Logger.error(message, true);
            expect($log.error.logs[0]).toContain(message, true);
            expect(Notification).toHaveBeenCalledWith(message, 'error');
        }));

        it('should log a message to the debug console when the debug method is called', inject(function(Notification, CONFIG) {
            CONFIG.debug = true;
            Logger.debug(message);
            expect($log.debug.logs[0]).toContain(message);
        }));

        it('should not log a message to the debug console when the debug method is called and CONFIG.debug is false', inject(function(Notification, CONFIG) {
            CONFIG.debug = false;
            Logger.debug(message);
            expect($log.debug.logs[0]).not.toContain(message);
        }));


    });

})();
