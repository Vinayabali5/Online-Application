module.exports = function(grunt) {
    "use strict";

    require('load-grunt-tasks')(grunt);

    grunt
        .initConfig({
            appConfig: {
                app: require('./bower.json').appPath || 'js',
                name: 'oas-ui',
                dist: 'dist',
                webapp: 'src/main/webapp',
                js: 'src/main/webapp/js',
                css: 'src/main/webapp/css',
                bower: 'src/main/webapp/bower_components',
                gruntConf: 'Gruntfile.js',
                karmaConf: 'karma.conf.js',
                tests: 'src/main/webapp/tests',
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
                options: {
                    configFile: '<%= appConfig.karmaConf %>',
                },
                unit: {
                    singleRun: true,
                },
                continuous: {
                    singleRun: false,
                    autoWatch: true
                }
            },
            // clean: {
            //     bower: '<%= appConfig.bower %>'
            // },
            // ngAnnotate: {
            //     dist: {
            //         files: {
            //             '<%= appConfig.dist %>/app.annotated.js': ['<%= appConfig.js %>/**/*.js', '!<%= appConfig.js %>/**/*.annotated.js']
            //         }
            //     }
            // },
            // useminPrepare: {
            //     html: '<%= appConfig.webapp %>/index.html',
            //     options: {
            //         dest: '<%= appConfig.dist %>/index-release.html',
            //     },
            // },
            // usemin: {
            //     html: '<%= appConfig.webapp %>/index.html',
            //     options: {
            //         dest: '<%= appConfig.dist %>/index-release.html',
            //     }
            // },
            bower_concat: {
                options: {
                    separator: ';'
                },
                all: {
                    dest: {
                        'js': '<%= appConfig.dist %>/vendor.js',
                        'css': '<%= appConfig.dist %>/vendor.css'
                    }
                }
            },
            html2js: {
                options: {
                    base: '<%= appConfig.webapp %>'
                },
                dist: {
                    src: ['<%= appConfig.js %>/**/*.html'],
                    dest: '<%= appConfig.dist %>/templates.js'
                }
            },
            concat: {
                options: {
                    separator: ';',
                    stripBanners: true
                },
                dist: {
                    src: [
                        '<%= appConfig.js %>/**/*.module.js',
                        '<%= appConfig.js %>/**/*.service.js',
                        '<%= appConfig.js %>/**/*.directive.js',
                        '<%= appConfig.js %>/**/*.js',
                    ],
                    dest: '<%= appConfig.dist %>/app.js'
                }
            },
            uglify: {
                options: {
                    mangle: false
                },
                bower: {
                    files: {
                        '<%= appConfig.dist %>/vendor.min.js': ['<%= appConfig.dist %>/vendor.js']
                    }
                },
                main: {
                    files: {
                        '<%= appConfig.dist %>/app.min.js': ['<%= appConfig.dist %>/app.js']
                    }
                }
            },
            angularFileLoader: {
                options: {
                    scripts: ['<%= appConfig.js %>/**/**.js']
                },
                main: {
                    src: ['<%= appConfig.webapp %>/index.html']
                },
                dist: {
                    src: ['<%= appConfig.dist %>/index.html']
                }
            },
            wiredep: {
                dev: {
                    src: ['<%= appConfig.webapp %>/index.html'],
                    options: {
                        directory: '<%= appConfig.bower %>'
                    }
                },
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
            },
            watch: {
                javascript: {
                    files: ['<%= appConfig.js %>/**/*.js'],
                    tasks: ['build'],
                    options: {
                        spawn: false,
                    },
                },
                html: {
                    files: ['<%= appConfig.webapp %>/**/*.html'],
                    tasks: ['jsbeautifier:html'],
                    options: {
                        spawn: false,
                    },
                },
                tests: {
                    files: ['<%= appConfig.webapp %>/tests/**/*.spec.js'],
                    tasks: ['jsbeautifier:javascript', 'karma:unit'],
                },
                bowerComponents: {
                    files: ['<%= appConfig.bower %>/**.*'],
                    tasks: ['bower_concat', 'wiredep:dev'],
                }

            },

        });

    grunt.registerTask('build', [
        'bower_concat',
        'jshint',
        'jsbeautifier:javascript',
        'jsbeautifier:html',
        'karma:unit',
        'wiredep:dev',
        'angularFileLoader:main'
    ]);

    grunt.registerTask('prepareDeployment', [
        'jshint',
        'wiredep:dev',
        'angularFileLoader:main'
    ]);

    grunt.registerTask('buildDist', [
        'bower_concat',
        'ngAnnotate',
        'uglify:bower',
        'uglify:main',
    ]);

    grunt.registerTask('default', ['build']);

    grunt.registerTask('serve', ['build', 'connect:server']);
};
