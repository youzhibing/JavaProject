字符流和字节流

字符流的由来： 因为数据编码的不同，而有了对字符进行高效操作的流对象。本质其实就是基于字节流读取时，去查了指定的码表。 字节流和字符流的区别：

读写单位不同：字节流以字节（8bit）为单位，字符流以字符为单位，根据码表映射字符，一次可能读多个字节。
处理对象不同：字节流能处理所有类型的数据（如图片、avi等），而字符流只能处理字符类型的数据。
结论：只要是处理纯文本数据，就优先考虑使用字符流。 除此之外都使用字节流。


Java IO流对象
输入字节流InputStreamIO 中输入字节流的继承图可见上图，可以看出：

InputStream 是所有的输入字节流的父类，它是一个抽象类。
ByteArrayInputStream、StringBufferInputStream、FileInputStream 是三种基本的介质流，它们分别从Byte 数组、StringBuffer、和本地文件中读取数据。
PipedInputStream 是从与其它线程共用的管道中读取数据，与Piped 相关的知识后续单独介绍。
ObjectInputStream 和所有FilterInputStream 的子类都是装饰流（装饰器模式的主角）。
 
输出字节流OutputStream

IO 中输出字节流的继承图可见上图，可以看出：

OutputStream 是所有的输出字节流的父类，它是一个抽象类。
ByteArrayOutputStream、FileOutputStream 是两种基本的介质流，它们分别向Byte 数组、和本地文件中写入数据。PipedOutputStream 是向与其它线程共用的管道中写入数据，
ObjectOutputStream 和所有FilterOutputStream 的子类都是装饰流。


字符输入流Reader

在上面的继承关系图中可以看出：

Reader 是所有的输入字符流的父类，它是一个抽象类。
CharReader、StringReader 是两种基本的介质流，它们分别将Char 数组、String中读取数据。PipedReader 是从与其它线程共用的管道中读取数据。
BufferedReader 很明显就是一个装饰器，它和其子类负责装饰其它Reader 对象。
FilterReader 是所有自定义具体装饰流的父类，其子类PushbackReader 对Reader 对象进行装饰，会增加一个行号。
InputStreamReader 是一个连接字节流和字符流的桥梁，它将字节流转变为字符流。FileReader 可以说是一个达到此功能、常用的工具类，在其源代码中明显使用了将FileInputStream 转变为Reader 的方法。
我们可以从这个类中得到一定的技巧。Reader 中各个类的用途和使用方法基本和InputStream 中的类使用一致。后面会有Reader 与InputStream 的对应关系。
 

字符输出流Writer

在上面的关系图中可以看出：

Writer 是所有的输出字符流的父类，它是一个抽象类。
CharArrayWriter、StringWriter 是两种基本的介质流，它们分别向Char 数组、String 中写入数据。PipedWriter 是向与其它线程共用的管道中写入数据，
BufferedWriter 是一个装饰器为Writer 提供缓冲功能。
PrintWriter 和PrintStream 极其类似，功能和使用也非常相似。
OutputStreamWriter 是OutputStream 到Writer 转换的桥梁，它的子类FileWriter 其实就是一个实现此功能的具体类（具体可以研究一SourceCode）。


字符流与字节流转换
转换流的特点：

其是字符流和字节流之间的桥梁
可对读取到的字节数据经过指定编码转换成字符
可对读取到的字符数据经过指定编码转换成字节
何时使用转换流？

当字节和字符之间有转换动作时；
流操作的数据需要编码或解码时。
具体的对象体现：

InputStreamReader:字节到字符的桥梁
OutputStreamWriter:字符到字节的桥梁
这两个流对象是字符体系中的成员，它们有转换作用，本身又是字符流，所以在构造的时候需要传入字节流对象进来。
