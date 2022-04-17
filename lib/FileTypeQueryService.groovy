/**
 * Define a service class to interrogate a file for its type.
 *
 * For simplicity, we assume that a filename has at most two extensions. It must
 * always have one extension corresponding to its specific type and may
 * optionally have a second extension denoting its compression type.
 *
 * @author Moritz E. Beber
 */
class FileTypeQueryService {

    protected static String cramExtension = 'cram'
    protected static Set<String> compressionExtensions = ['gz', 'bz2', 'zstd', 'lz4', cramExtension] as Set<String>
    protected static Set<String> fastaExtensions = ['fasta', 'fa', 'faa', 'fna', 'ffn', 'frn'] as Set<String>
    protected static Set<String> fastqExtensions = ['fastq', 'fq'] as Set<String>
    protected static Set<String> samExtensions = ['sam', 'bam', cramExtension] as Set<String>

    static boolean isCompressed(filename) {
        return compressionExtensions.contains(filename.extension)
    }

    static String getCompressionType(filename) {
        if (!isCompressed(filename)) {
            throw new Exception('The given file does not seem to be compressed.')
        }
        return filename.extension
    }

    static boolean isFastA(filename) {
        if (isCompressed(filename)) {
            filename = file(filename.baseName)
        }
        return fastaExtensions.contains(filename.extension)
    }

    static boolean isFastQ(filename) {
        if (isCompressed(filename)) {
            filename = file(filename.baseName)
        }
        return fastqExtensions.contains(filename.extension)
    }

    static boolean isSAM(filename) {
        if (isCompressed(filename)) {
            if (filename.extension == cramExtension) {
                return true
            }
            filename = file(filename.baseName)
        }
        return samExtensions.contains(filename.extension)
    }

    static String getFileType(filename) {
        if (isCompressed(filename)) {
            if (filename.extension == cramExtension) {
                return cramExtension
            }
            filename = file(filename.baseName)
        }
        return filename.extension
    }

    static String getSimpleName(filename) {
        if (isCompressed(filename)) {
            if (filename.extension == cramExtension) {
                return filename.baseName
            }
            filename = file(filename.baseName)
        }
        return filename.baseName
    }

    static Map getFileInfo(filename) {
        Map result = [:].tap {
            is_compressed = isCompressed(filename)
            compression_type = is_compressed ? getCompressionType(filename) : null
            is_fasta = isFastA(filename)
            is_fastq = isFastQ(filename)
            is_sam = isSAM(filename)
            file_type = getFileType(filename)
            base_name = getBasename(filename)
        }
        return result
    }

}
