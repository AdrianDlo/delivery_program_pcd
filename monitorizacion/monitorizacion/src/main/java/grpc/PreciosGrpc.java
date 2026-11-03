package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: precios.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PreciosGrpc {

  private PreciosGrpc() {}

  public static final String SERVICE_NAME = "Precios";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.PreciosProto.PreciosRequest,
      grpc.PreciosProto.PreciosReply> getCalcularPreciosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "calcularPrecios",
      requestType = grpc.PreciosProto.PreciosRequest.class,
      responseType = grpc.PreciosProto.PreciosReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.PreciosProto.PreciosRequest,
      grpc.PreciosProto.PreciosReply> getCalcularPreciosMethod() {
    io.grpc.MethodDescriptor<grpc.PreciosProto.PreciosRequest, grpc.PreciosProto.PreciosReply> getCalcularPreciosMethod;
    if ((getCalcularPreciosMethod = PreciosGrpc.getCalcularPreciosMethod) == null) {
      synchronized (PreciosGrpc.class) {
        if ((getCalcularPreciosMethod = PreciosGrpc.getCalcularPreciosMethod) == null) {
          PreciosGrpc.getCalcularPreciosMethod = getCalcularPreciosMethod =
              io.grpc.MethodDescriptor.<grpc.PreciosProto.PreciosRequest, grpc.PreciosProto.PreciosReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "calcularPrecios"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.PreciosProto.PreciosRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.PreciosProto.PreciosReply.getDefaultInstance()))
              .setSchemaDescriptor(new PreciosMethodDescriptorSupplier("calcularPrecios"))
              .build();
        }
      }
    }
    return getCalcularPreciosMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PreciosStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PreciosStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PreciosStub>() {
        @java.lang.Override
        public PreciosStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PreciosStub(channel, callOptions);
        }
      };
    return PreciosStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PreciosBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PreciosBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PreciosBlockingStub>() {
        @java.lang.Override
        public PreciosBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PreciosBlockingStub(channel, callOptions);
        }
      };
    return PreciosBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PreciosFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PreciosFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PreciosFutureStub>() {
        @java.lang.Override
        public PreciosFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PreciosFutureStub(channel, callOptions);
        }
      };
    return PreciosFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<grpc.PreciosProto.PreciosRequest> calcularPrecios(
        io.grpc.stub.StreamObserver<grpc.PreciosProto.PreciosReply> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCalcularPreciosMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Precios.
   */
  public static abstract class PreciosImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PreciosGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Precios.
   */
  public static final class PreciosStub
      extends io.grpc.stub.AbstractAsyncStub<PreciosStub> {
    private PreciosStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PreciosStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PreciosStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.PreciosProto.PreciosRequest> calcularPrecios(
        io.grpc.stub.StreamObserver<grpc.PreciosProto.PreciosReply> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getCalcularPreciosMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Precios.
   */
  public static final class PreciosBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PreciosBlockingStub> {
    private PreciosBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PreciosBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PreciosBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Precios.
   */
  public static final class PreciosFutureStub
      extends io.grpc.stub.AbstractFutureStub<PreciosFutureStub> {
    private PreciosFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PreciosFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PreciosFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CALCULAR_PRECIOS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULAR_PRECIOS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.calcularPrecios(
              (io.grpc.stub.StreamObserver<grpc.PreciosProto.PreciosReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCalcularPreciosMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              grpc.PreciosProto.PreciosRequest,
              grpc.PreciosProto.PreciosReply>(
                service, METHODID_CALCULAR_PRECIOS)))
        .build();
  }

  private static abstract class PreciosBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PreciosBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.PreciosProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Precios");
    }
  }

  private static final class PreciosFileDescriptorSupplier
      extends PreciosBaseDescriptorSupplier {
    PreciosFileDescriptorSupplier() {}
  }

  private static final class PreciosMethodDescriptorSupplier
      extends PreciosBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PreciosMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PreciosGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PreciosFileDescriptorSupplier())
              .addMethod(getCalcularPreciosMethod())
              .build();
        }
      }
    }
    return result;
  }
}
