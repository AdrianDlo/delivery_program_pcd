package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: actualizarPrecios.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ActualizarPreciosGrpc {

  private ActualizarPreciosGrpc() {}

  public static final String SERVICE_NAME = "ActualizarPrecios";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.ActualizarPreciosProto.ActualizarRequest,
      grpc.ActualizarPreciosProto.ActualizarReply> getActualizarPreciosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "actualizarPrecios",
      requestType = grpc.ActualizarPreciosProto.ActualizarRequest.class,
      responseType = grpc.ActualizarPreciosProto.ActualizarReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.ActualizarPreciosProto.ActualizarRequest,
      grpc.ActualizarPreciosProto.ActualizarReply> getActualizarPreciosMethod() {
    io.grpc.MethodDescriptor<grpc.ActualizarPreciosProto.ActualizarRequest, grpc.ActualizarPreciosProto.ActualizarReply> getActualizarPreciosMethod;
    if ((getActualizarPreciosMethod = ActualizarPreciosGrpc.getActualizarPreciosMethod) == null) {
      synchronized (ActualizarPreciosGrpc.class) {
        if ((getActualizarPreciosMethod = ActualizarPreciosGrpc.getActualizarPreciosMethod) == null) {
          ActualizarPreciosGrpc.getActualizarPreciosMethod = getActualizarPreciosMethod =
              io.grpc.MethodDescriptor.<grpc.ActualizarPreciosProto.ActualizarRequest, grpc.ActualizarPreciosProto.ActualizarReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "actualizarPrecios"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ActualizarPreciosProto.ActualizarRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ActualizarPreciosProto.ActualizarReply.getDefaultInstance()))
              .setSchemaDescriptor(new ActualizarPreciosMethodDescriptorSupplier("actualizarPrecios"))
              .build();
        }
      }
    }
    return getActualizarPreciosMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ActualizarPreciosStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ActualizarPreciosStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ActualizarPreciosStub>() {
        @java.lang.Override
        public ActualizarPreciosStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ActualizarPreciosStub(channel, callOptions);
        }
      };
    return ActualizarPreciosStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ActualizarPreciosBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ActualizarPreciosBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ActualizarPreciosBlockingStub>() {
        @java.lang.Override
        public ActualizarPreciosBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ActualizarPreciosBlockingStub(channel, callOptions);
        }
      };
    return ActualizarPreciosBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ActualizarPreciosFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ActualizarPreciosFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ActualizarPreciosFutureStub>() {
        @java.lang.Override
        public ActualizarPreciosFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ActualizarPreciosFutureStub(channel, callOptions);
        }
      };
    return ActualizarPreciosFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void actualizarPrecios(grpc.ActualizarPreciosProto.ActualizarRequest request,
        io.grpc.stub.StreamObserver<grpc.ActualizarPreciosProto.ActualizarReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getActualizarPreciosMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ActualizarPrecios.
   */
  public static abstract class ActualizarPreciosImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ActualizarPreciosGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ActualizarPrecios.
   */
  public static final class ActualizarPreciosStub
      extends io.grpc.stub.AbstractAsyncStub<ActualizarPreciosStub> {
    private ActualizarPreciosStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActualizarPreciosStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ActualizarPreciosStub(channel, callOptions);
    }

    /**
     */
    public void actualizarPrecios(grpc.ActualizarPreciosProto.ActualizarRequest request,
        io.grpc.stub.StreamObserver<grpc.ActualizarPreciosProto.ActualizarReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getActualizarPreciosMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ActualizarPrecios.
   */
  public static final class ActualizarPreciosBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ActualizarPreciosBlockingStub> {
    private ActualizarPreciosBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActualizarPreciosBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ActualizarPreciosBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<grpc.ActualizarPreciosProto.ActualizarReply> actualizarPrecios(
        grpc.ActualizarPreciosProto.ActualizarRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getActualizarPreciosMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ActualizarPrecios.
   */
  public static final class ActualizarPreciosFutureStub
      extends io.grpc.stub.AbstractFutureStub<ActualizarPreciosFutureStub> {
    private ActualizarPreciosFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActualizarPreciosFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ActualizarPreciosFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ACTUALIZAR_PRECIOS = 0;

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
        case METHODID_ACTUALIZAR_PRECIOS:
          serviceImpl.actualizarPrecios((grpc.ActualizarPreciosProto.ActualizarRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ActualizarPreciosProto.ActualizarReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getActualizarPreciosMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              grpc.ActualizarPreciosProto.ActualizarRequest,
              grpc.ActualizarPreciosProto.ActualizarReply>(
                service, METHODID_ACTUALIZAR_PRECIOS)))
        .build();
  }

  private static abstract class ActualizarPreciosBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ActualizarPreciosBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.ActualizarPreciosProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ActualizarPrecios");
    }
  }

  private static final class ActualizarPreciosFileDescriptorSupplier
      extends ActualizarPreciosBaseDescriptorSupplier {
    ActualizarPreciosFileDescriptorSupplier() {}
  }

  private static final class ActualizarPreciosMethodDescriptorSupplier
      extends ActualizarPreciosBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ActualizarPreciosMethodDescriptorSupplier(String methodName) {
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
      synchronized (ActualizarPreciosGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ActualizarPreciosFileDescriptorSupplier())
              .addMethod(getActualizarPreciosMethod())
              .build();
        }
      }
    }
    return result;
  }
}
