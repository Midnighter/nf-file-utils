#!/usr/bin/env nextflow

nextflow.enable.dsl = 2

workflow {

    def filename1 = file('genome.fasta.gz')

    assert FileTypeQueryService.isCompressed(filename1)
    // assert FileTypeQueryService.isFastA(filename1)
    // assert !FileTypeQueryService.isFastQ(filename1)
    // assert !FileTypeQueryService.isSAM(filename1)
    // assert FileTypeQueryService.getCompressionType(filename1) == 'gz'
    // assert FileTypeQueryService.getFileType(filename1) == 'fasta'
    // assert FileTypeQueryService.getSimpleName(filename1) == 'genome'

    def filename2 = file('genome.fasta')

    assert !FileTypeQueryService.isCompressed(filename2)
    // assert FileTypeQueryService.isFastA(filename2)
    // assert !FileTypeQueryService.isFastQ(filename2)
    // assert !FileTypeQueryService.isSAM(filename2)
    // assert FileTypeQueryService.getFileType(filename2) == 'fasta'
    // assert FileTypeQueryService.getSimpleName(filename2) == 'genome'

    def filename3 = file('reads.fastq.bz2')

    assert FileTypeQueryService.isCompressed(filename3)
    // assert !FileTypeQueryService.isFastA(filename3)
    // assert FileTypeQueryService.isFastQ(filename3)
    // assert !FileTypeQueryService.isSAM(filename3)
    // assert FileTypeQueryService.getCompressionType(filename3) == 'bz2'
    // assert FileTypeQueryService.getFileType(filename3) == 'fastq'
    // assert FileTypeQueryService.getSimpleName(filename3) == 'reads'

    def filename4 = file('align.cram')

    assert FileTypeQueryService.isCompressed(filename4)
    // assert !FileTypeQueryService.isFastA(filename4)
    // assert !FileTypeQueryService.isFastQ(filename4)
    // assert FileTypeQueryService.isSAM(filename4)
    // assert FileTypeQueryService.getCompressionType(filename3) == 'cram'
    // assert FileTypeQueryService.getFileType(filename4) == 'cram'
    // assert FileTypeQueryService.getSimpleName(filename4) == 'align'

}
