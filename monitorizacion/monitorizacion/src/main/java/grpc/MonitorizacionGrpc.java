package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: monitorizacion.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MonitorizacionGrpc {

  private MonitorizacionGrpc() {}

  public static final String SERVICE_NAME = "directory.Monitorizacion";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.MonitorizacionProto.ConsumoRequest,
      grpc.MonitorizacionProto.ConsumoReply> getAnotarConsumoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "anotarConsumo",
      requestType = grpc.MonitorizacionProto.ConsumoRequest.class,
      responseType = grpc.MonitorizacionProto.ConsumoReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.MonitorizacionProto.ConsumoRequest,
      grpc.MonitorizacionProto.ConsumoReply> getAnotarConsumoMethod() {
    io.grpc.MethodDescriptor<grpc.MonitorizacionProto.ConsumoRequest, grpc.MonitorizacionProto.ConsumoReply> getAnotarConsumoMethod;
    if ((getAnotarConsumoMethod = MonitorizacionGrpc.getAnotarConsumoMethod) == null) {
      synchronized (MonitorizacionGrpc.class) {
        if ((getAnotarConsumoMethod = MonitorizacionGrpc.getAnotarConsumoMethod) == null) {
          MonitorizacionGrpc.getAnotarConsumoMethod = getAnotarConsumoMethod =
              io.grpc.MethodDescriptor.<grpc.MonitorizacionProto.ConsumoRequest, grpc.MonitorizacionProto.ConsumoReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "anotarConsumo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.MonitorizacionProto.ConsumoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.MonitorizacionProto.ConsumoReply.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorizacionMethodDescriptorSupplier("anotarConsumo"))
              .build();
        }
      }
    }
    return getAnotarConsumoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.MonitorizacionProto.DemandaRequest,
      grpc.MonitorizacionProto.DemandaReply> getDemandaSolarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "demandaSolar",
      requestType = grpc.MonitorizacionProto.DemandaRequest.class,
      responseType = grpc.MonitorizacionProto.DemandaReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.MonitorizacionProto.DemandaRequest,
      grpc.MonitorizacionProto.DemandaReply> getDemandaSolarMethod() {
    io.grpc.MethodDescriptor<grpc.MonitorizacionProto.DemandaRequest, grpc.MonitorizacionProto.DemandaReply> getDemandaSolarMethod;
    if ((getDemandaSolarMethod = MonitorizacionGrpc.getDemandaSolarMethod) == null) {
      synchronized (MonitorizacionGrpc.class) {
        if ((getDemandaSolarMethod = MonitorizacionGrpc.getDemandaSolarMethod) == null) {
          MonitorizacionGrpc.getDemandaSolarMethod = getDemandaSolarMethod =
              io.grpc.MethodDescriptor.<grpc.MonitorizacionProto.DemandaRequest, grpc.MonitorizacionProto.DemandaReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "demandaSolar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.MonitorizacionProto.DemandaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.MonitorizacionProto.DemandaReply.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorizacionMethodDescriptorSupplier("demandaSolar"))
              .build();
        }
      }
    }
    return getDemandaSolarMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.MonitorizacionProto.DireccionRequest,
      grpc.MonitorizacionProto.DireccionReply> getConsumosDireccionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "consumosDireccion",
      requestType = grpc.MonitorizacionProto.DireccionRequest.class,
      responseType = grpc.MonitorizacionProto.DireccionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.MonitorizacionProto.DireccionRequest,
      grpc.MonitorizacionProto.DireccionReply> getConsumosDireccionMethod() {
    io.grpc.MethodDescriptor<grpc.MonitorizacionProto.DireccionRequest, grpc.MonitorizacionProto.DireccionReply> getConsumosDireccionMethod;
    if ((getConsumosDireccionMethod = MonitorizacionGrpc.getConsumosDireccionMethod) == null) {
      synchronized (MonitorizacionGrpc.class) {
        if ((getConsumosDireccionMethod = MonitorizacionGrpc.getConsumosDireccionMethod) == null) {
          MonitorizacionGrpc.getConsumosDireccionMethod = getConsumosDireccionMethod =
              io.grpc.MethodDescriptor.<grpc.MonitorizacionProto.DireccionRequest, grpc.MonitorizacionProto.DireccionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "consumosDireccion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.MonitorizacionProto.DireccionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.MonitorizacionProto.DireccionReply.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorizacionMethodDescriptorSupplier("consumosDireccion"))
              .build();
        }
      }
    }
    return getConsumosDireccionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MonitorizacionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitorizacionStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitorizacionStub>() {
        @java.lang.Override
        public MonitorizacionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitorizacionStub(channel, callOptions);
        }
      };
    return MonitorizacionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MonitorizacionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitorizacionBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitorizacionBlockingStub>() {
        @java.lang.Override
        public MonitorizacionBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitorizacionBlockingStub(channel, callOptions);
        }
      };
    return MonitorizacionBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MonitorizacionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitorizacionFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitorizacionFutureStub>() {
        @java.lang.Override
        public MonitorizacionFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitorizacionFutureStub(channel, callOptions);
        }
      };
    return MonitorizacionFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void anotarConsumo(grpc.MonitorizacionProto.ConsumoRequest request,
        io.grpc.stub.StreamObserver<grpc.MonitorizacionProto.ConsumoReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAnotarConsumoMethod(), responseObserver);
    }

    /**
     */
    default void demandaSolar(grpc.MonitorizacionProto.DemandaRequest request,
        io.grpc.stub.StreamObserver<grpc.MonitorizacionProto.DemandaReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDemandaSolarMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<grpc.MonitorizacionProto.DireccionRequest> consumosDireccion(
        io.grpc.stub.StreamObserver<grpc.MonitorizacionProto.DireccionReply> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getConsumosDireccionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Monitorizacion.
   */
  public static abstract class MonitorizacionImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MonitorizacionGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Monitorizacion.
   */
  public static final class MonitorizacionStub
      extends io.grpc.stub.AbstractAsyncStub<MonitorizacionStub> {
    private MonitorizacionStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorizacionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitorizacionStub(channel, callOptions);
    }

    /**
     */
    public void anotarConsumo(grpc.MonitorizacionProto.ConsumoRequest request,
        io.grpc.stub.StreamObserver<grpc.MonitorizacionProto.ConsumoReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnotarConsumoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void demandaSolar(grpc.MonitorizacionProto.DemandaRequest request,
        io.grpc.stub.StreamObserver<grpc.MonitorizacionProto.DemandaReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getDemandaSolarMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.MonitorizacionProto.DireccionRequest> consumosDireccion(
        io.grpc.stub.StreamObserver<grpc.MonitorizacionProto.DireccionReply> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getConsumosDireccionMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Monitorizacion.
   */
  public static final class MonitorizacionBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MonitorizacionBlockingStub> {
    private MonitorizacionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorizacionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitorizacionBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.MonitorizacionProto.ConsumoReply anotarConsumo(grpc.MonitorizacionProto.ConsumoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnotarConsumoMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.MonitorizacionProto.DemandaReply> demandaSolar(
        grpc.MonitorizacionProto.DemandaRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getDemandaSolarMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Monitorizacion.
   */
  public static final class MonitorizacionFutureStub
      extends io.grpc.stub.AbstractFutureStub<MonitorizacionFutureStub> {
    private MonitorizacionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorizacionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitorizacionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.MonitorizacionProto.ConsumoReply> anotarConsumo(
        grpc.MonitorizacionProto.ConsumoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnotarConsumoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANOTAR_CONSUMO = 0;
  private static final int METHODID_DEMANDA_SOLAR = 1;
  private static final int METHODID_CONSUMOS_DIRECCION = 2;

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
        case METHODID_ANOTAR_CONSUMO:
          serviceImpl.anotarConsumo((grpc.MonitorizacionProto.ConsumoRequest) request,
              (io.grpc.stub.StreamObserver<grpc.MonitorizacionProto.ConsumoReply>) responseObserver);
          break;
        case METHODID_DEMANDA_SOLAR:
          serviceImpl.demandaSolar((grpc.MonitorizacionProto.DemandaRequest) request,
              (io.grpc.stub.StreamObserver<grpc.MonitorizacionProto.DemandaReply>) responseObserver);
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
        case METHODID_CONSUMOS_DIRECCION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.consumosDireccion(
              (io.grpc.stub.StreamObserver<grpc.MonitorizacionProto.DireccionReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAnotarConsumoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.MonitorizacionProto.ConsumoRequest,
              grpc.MonitorizacionProto.ConsumoReply>(
                service, METHODID_ANOTAR_CONSUMO)))
        .addMethod(
          getDemandaSolarMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              grpc.MonitorizacionProto.DemandaRequest,
              grpc.MonitorizacionProto.DemandaReply>(
                service, METHODID_DEMANDA_SOLAR)))
        .addMethod(
          getConsumosDireccionMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              grpc.MonitorizacionProto.DireccionRequest,
              grpc.MonitorizacionProto.DireccionReply>(
                service, METHODID_CONSUMOS_DIRECCION)))
        .build();
  }

  private static abstract class MonitorizacionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MonitorizacionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.MonitorizacionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Monitorizacion");
    }
  }

  private static final class MonitorizacionFileDescriptorSupplier
      extends MonitorizacionBaseDescriptorSupplier {
    MonitorizacionFileDescriptorSupplier() {}
  }

  private static final class MonitorizacionMethodDescriptorSupplier
      extends MonitorizacionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MonitorizacionMethodDescriptorSupplier(String methodName) {
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
      synchronized (MonitorizacionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MonitorizacionFileDescriptorSupplier())
              .addMethod(getAnotarConsumoMethod())
              .addMethod(getDemandaSolarMethod())
              .addMethod(getConsumosDireccionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
