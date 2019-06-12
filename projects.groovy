def final projects = [
        'project_a': [
                scmurl: 'https://github.com/pszubiak/dsl-example-2',
                release_script: 'scripts/release.sh',
                nightly_build_script: 'scripts/pr.sh',
        ],

        'project_b': [
                scmurl: 'https://github.com/pszubiak/dsl-example-2',
                release_script: 'scripts/release.sh',
                nightly_build_script: 'scripts/nightly.sh',
        ]
]


for (project in projects) {
    folder(project.key)
}