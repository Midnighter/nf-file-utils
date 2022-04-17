# Nextflow File Utilities

The main contribution of the repository is a [service class](lib/FileTypeQueryService.groovy) with static methods to query files/paths for their type and compression. It is intended to be used within [nextflow](https://www.nextflow.io/) workflows.

## Usage

In order to make use of the [service class](lib/FileTypeQueryService.groovy), it should be placed in your pipeline's `lib` directory as demonstrated here. If you use it inside of modules, you may have to import it as

```nextflow
import FileTypeQueryService
```

## Copyright

* Copyright © 2022, Moritz E. Beber
* Free software, distributed under the [MIT license](LICENSE)
