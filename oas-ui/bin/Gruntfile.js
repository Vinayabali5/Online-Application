module.exports = function(grunt) {
    "use strict";

    require('load-grunt-tasks')(grunt);

    grunt
        .initConfig({
            appConfig: {
                app: require('./bower.json').appPath || 'js',
                name: 'oas-ui',
                webapp: 'src/main/resources/static',
                js: 'src/main/resources/static/js',
                css: 'src/main/resources/static/css',
                bower: 'src/main/resources/static/bower_components',
                gruntConf: 'Gruntfile.js',
                karmaConf: 'karma.conf.js',
                tests: 'src/main/resources/static/tests'
            },
            clean: {
                bower: '<%= appConfig.bower %>'
            },
            bower: {
                install: {
                    options: {
                        install: true,
                        copy: false
                    }
                }
            },
            jshint: {
                options: {
                    jshintrc: '.jshintrc'
                },
                all: [
                    '<%= appConfig.gruntConf %>',
                    '<%= appConfig.karmaConf %>',
                    '<%= appConfig.js %>/**/*.js',
                    '<%= appConfig.tests %>/**/*.js'
                ]
            },
            karma: {
                unit: {
                    configFile: '<%= appConfig.karmaConf %>',
                }
            },
            angularFileLoader: {
                options: {
                    scripts: ['<%= appConfig.js %>/**/**.js']
                },
                dev: {
                    src: ['<%= appConfig.webapp %>/index.html']
                },
            },
            wiredep: {
                dev: {
                    src: ['<%= appConfig.webapp %>/index.html'],
                    options: {
                        directory: '<%= appConfig.bower %>'
                    }
                },
            },
            ngAnnotate: {
                dist: {
                    files: [{
                        expand: true,
                        src: ['<%= appConfig.js %>/**/*.js', '!<%= appConfig.js %>/**/*.annotated.js'],
                        dest: '<%= appConfig.dist %>/annotated/',
                        ext: '.annotated.js',
                        extDot: 'last'
                    }],
                }
            },
            "jsbeautifier": {
                "javascript": {
                    src: [
                        '<%= appConfig.gruntConf %>',
                        '<%= appConfig.karmaConf %>',
                        '<%= appConfig.js %>/**/*.js',
                        '<%= appConfig.tests %>/**/*.js'
                    ],
                    options: {}
                },
                "html": {
                    src: [
                        '<%= appConfig.webapp %>/index.html',
                        '<%= appConfig.webapp %>/partials/**/**.html',
                        '<%= appConfig.js %>/**/**.html'
                    ],
                    options: {
                        preserveNewlines: true,
                    }
                },
            }

        });

    grunt.registerTask('build', [
        'jshint',
        'jsbeautifier:javascript',
        'jsbeautifier:html',
        'wiredep:dev',
        'angularFileLoader:dev'
    ]);

    grunt.registerTask('default', ['build']);
};
