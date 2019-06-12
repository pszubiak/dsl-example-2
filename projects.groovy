def final projects = [
        'project_a': [
                github: 'pszubiak/dsl-example-2',
                release_script: 'scripts/release.sh',
                nightly_build_script: 'scripts/pr.sh',
        ],

        'project_b': [
                github: 'pszubiak/dsl-example-2',
                release_script: 'scripts/release.sh',
                nightly_build_script: 'scripts/nightly.sh',
        ]
]


for (project in projects) {

    // Creates or updates a folder.
    folder(project.key)

    // Creates or updates a free style job.
    job("${project.key}/${project.key}-release-job") {

        // Allows a job to check out sources from an SCM provider.
        scm {

            //Adds a Git SCM source for a GitHub repository.
            github($project.get('github'))
        }
    }
}