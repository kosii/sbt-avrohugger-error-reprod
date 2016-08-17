
object Main extends App {
  import foo.scala._
  import org.apache.avro.specific._
  import org.apache.avro.io._

  val status = Status()
  val out = new java.io.ByteArrayOutputStream

  val writer: SpecificDatumWriter[Status] = new SpecificDatumWriter[Status](Status.SCHEMA$)
  val encoder: BinaryEncoder = EncoderFactory.get().binaryEncoder(out, null)
  writer.write(status, encoder)
  encoder.flush()
  out.close
  val outArray = out.toByteArray

  val reader: SpecificDatumReader[Status] = new SpecificDatumReader[Status](Status.SCHEMA$)
  val res: Status = reader.read(null, DecoderFactory.get().binaryDecoder(outArray, null))
  println(res)
}
