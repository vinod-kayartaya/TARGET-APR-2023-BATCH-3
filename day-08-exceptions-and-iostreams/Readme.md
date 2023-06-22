# I/O Streams

Types of streams

- JDK 1.0 introduced IO streams
- JDK 1.1 introduced Character streams
  - the older streams are termed as Binary (or byte) streams

Binary/Byte Streams

- java.io.InputStream
  - an abstraction for reading data from a source (such as Keyboard, Mouse, Mic, File, Network/Socket, Scanner, Camera)
  - an abstract class
  - important subclasses:
    - FileInputStream
    - SocketInputStream
    - BufferedInputStream
    - DataInputStream
    - ObjectInputStream
    - ByteArrayInputStream
- java.io.OutputStream
  - an abstraction for writing data to a target (such as Monitor, Audio device, File, Network/Socket, Printer)
  - abstract class
  - important subclasses:
    - FileOutputStream
    - SocketOutputStream
    - BufferedOutputStream
    - DataOutputStream
    - ObjectOutputStream
    - ByteArrayOutputStream
    - PrintStream

Character Streams

- java.io.Reader
  - abstract class
  - only reads character data
    - cannot be used for reading actual int, double, object ect
  - Important subclasses:
    - InputStreamReader - converts an InputStream into Reader
    - FileReader
    - LineReader
    - BufferedReader
    - StringReader
    - UTF8Reader
- java.io.Writer
  - abstract class
  - Important subclasses:
    - OutputStreamWriter - converts an OutputStream into a Writer
    - FileWriter
    - PrintWriter
    - StringWriter
