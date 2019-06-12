def final projects = [
        'project-a': [
                github: 'pszubiak/dsl-example-2',
                nightly_script: 'scripts/nightly.sh'
        ],

        'project-b': [
                github: 'pszubiak/dsl-example-2',
                nightly_script: 'scripts/nightly.sh'
        ],

        'project-c': [
                github: 'pszubiak/dsl-example-2',
                nightly_script: 'scripts/nightly.sh'
        ],

        'project-d': [
                github: 'pszubiak/dsl-example-2',
                nightly_script: 'scripts/nightly.sh'
        ]
]


for (project in projects) {

    // Creates or updates a folder.
    folder('nightly-jobs')

    // Creates or updates a free style job.
    job("nightly-jobs/${project.key}-nightly-build") {

        // Allows a job to check out sources from an SCM provider.
        scm {

            //Adds a Git SCM source for a GitHub repository.
            github(project.value.github)
        }

        // Adds build steps to the jobs.
        steps {

            // Runs a shell script.
            shell(readFileFromWorkspace(project.value.nightly_script))
        }

        // Adds post-build actions to the job.
        publishers {

            // Sends email notifications.
            mailer('boss@somedomain.org me@somedomain.org')
        }
    }
}