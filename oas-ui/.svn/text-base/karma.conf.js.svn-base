module.exports = function(config) {
    config.set({
        preprocessors: {
            '**/*.html': ['ng-html2js']
        },

        basePath: 'src/main/webapp/',
        frameworks: ['bower', 'jasmine'],
        autoWatch: true,

        browsers: [
            'ChromeHeadless',
            'FirefoxHeadless',
        ],
        customLaunchers: {
            FirefoxHeadless: {
                base: 'Firefox',
                flags: ['--headless']
            }
        },

        files: [
            'js/**/*.module.js',
            'js/**/*.service.js',
            'js/**/*.directive.js',
            'js/**/*.js',
            'tests/**/*.spec.js',
            '**/*.html',
        ],
        bowerPackages: [
            'jquery',
            'bootstrap',
            'bootbox',
            'angular',
            'angular-mocks',
            'angular-cookies',
            'angular-ui-router',
            'angular-bootstrap',
            'angular-ui-notification',
        ],

        //logLevel: config.LOG_INFO,

        ngHtml2JsPreprocessor: {
            stripPrefix: '',
            prependPrefix: 'served/',
            cacheIdFromPath: function(filepath) {
                return filepath;
            },
            moduleName: 'html'
        }

    });
};
