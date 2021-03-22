package com.magalu.platform.grpc_test;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.25.0)",
    comments = "Source: task.proto")
public final class TaskServiceGrpc {

  private TaskServiceGrpc() {}

  public static final String SERVICE_NAME = "TaskService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.magalu.platform.grpc_test.TaskProto.Empty,
      com.magalu.platform.grpc_test.TaskProto.TaskList> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.magalu.platform.grpc_test.TaskProto.Empty.class,
      responseType = com.magalu.platform.grpc_test.TaskProto.TaskList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.magalu.platform.grpc_test.TaskProto.Empty,
      com.magalu.platform.grpc_test.TaskProto.TaskList> getListMethod() {
    io.grpc.MethodDescriptor<com.magalu.platform.grpc_test.TaskProto.Empty, com.magalu.platform.grpc_test.TaskProto.TaskList> getListMethod;
    if ((getListMethod = TaskServiceGrpc.getListMethod) == null) {
      synchronized (TaskServiceGrpc.class) {
        if ((getListMethod = TaskServiceGrpc.getListMethod) == null) {
          TaskServiceGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<com.magalu.platform.grpc_test.TaskProto.Empty, com.magalu.platform.grpc_test.TaskProto.TaskList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.magalu.platform.grpc_test.TaskProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.magalu.platform.grpc_test.TaskProto.TaskList.getDefaultInstance()))
              .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.magalu.platform.grpc_test.TaskProto.TaskT,
      com.magalu.platform.grpc_test.TaskProto.TaskList> getSaveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Save",
      requestType = com.magalu.platform.grpc_test.TaskProto.TaskT.class,
      responseType = com.magalu.platform.grpc_test.TaskProto.TaskList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.magalu.platform.grpc_test.TaskProto.TaskT,
      com.magalu.platform.grpc_test.TaskProto.TaskList> getSaveMethod() {
    io.grpc.MethodDescriptor<com.magalu.platform.grpc_test.TaskProto.TaskT, com.magalu.platform.grpc_test.TaskProto.TaskList> getSaveMethod;
    if ((getSaveMethod = TaskServiceGrpc.getSaveMethod) == null) {
      synchronized (TaskServiceGrpc.class) {
        if ((getSaveMethod = TaskServiceGrpc.getSaveMethod) == null) {
          TaskServiceGrpc.getSaveMethod = getSaveMethod =
              io.grpc.MethodDescriptor.<com.magalu.platform.grpc_test.TaskProto.TaskT, com.magalu.platform.grpc_test.TaskProto.TaskList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Save"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.magalu.platform.grpc_test.TaskProto.TaskT.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.magalu.platform.grpc_test.TaskProto.TaskList.getDefaultInstance()))
              .build();
        }
      }
    }
    return getSaveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TaskServiceStub newStub(io.grpc.Channel channel) {
    return new TaskServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TaskServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TaskServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TaskServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TaskServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TaskServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void list(com.magalu.platform.grpc_test.TaskProto.Empty request,
        io.grpc.stub.StreamObserver<com.magalu.platform.grpc_test.TaskProto.TaskList> responseObserver) {
      asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     */
    public void save(com.magalu.platform.grpc_test.TaskProto.TaskT request,
        io.grpc.stub.StreamObserver<com.magalu.platform.grpc_test.TaskProto.TaskList> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.magalu.platform.grpc_test.TaskProto.Empty,
                com.magalu.platform.grpc_test.TaskProto.TaskList>(
                  this, METHODID_LIST)))
          .addMethod(
            getSaveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.magalu.platform.grpc_test.TaskProto.TaskT,
                com.magalu.platform.grpc_test.TaskProto.TaskList>(
                  this, METHODID_SAVE)))
          .build();
    }
  }

  /**
   */
  public static final class TaskServiceStub extends io.grpc.stub.AbstractStub<TaskServiceStub> {
    private TaskServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskServiceStub(channel, callOptions);
    }

    /**
     */
    public void list(com.magalu.platform.grpc_test.TaskProto.Empty request,
        io.grpc.stub.StreamObserver<com.magalu.platform.grpc_test.TaskProto.TaskList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void save(com.magalu.platform.grpc_test.TaskProto.TaskT request,
        io.grpc.stub.StreamObserver<com.magalu.platform.grpc_test.TaskProto.TaskList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TaskServiceBlockingStub extends io.grpc.stub.AbstractStub<TaskServiceBlockingStub> {
    private TaskServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.magalu.platform.grpc_test.TaskProto.TaskList list(com.magalu.platform.grpc_test.TaskProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.magalu.platform.grpc_test.TaskProto.TaskList save(com.magalu.platform.grpc_test.TaskProto.TaskT request) {
      return blockingUnaryCall(
          getChannel(), getSaveMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TaskServiceFutureStub extends io.grpc.stub.AbstractStub<TaskServiceFutureStub> {
    private TaskServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.magalu.platform.grpc_test.TaskProto.TaskList> list(
        com.magalu.platform.grpc_test.TaskProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.magalu.platform.grpc_test.TaskProto.TaskList> save(
        com.magalu.platform.grpc_test.TaskProto.TaskT request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST = 0;
  private static final int METHODID_SAVE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TaskServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TaskServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST:
          serviceImpl.list((com.magalu.platform.grpc_test.TaskProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.magalu.platform.grpc_test.TaskProto.TaskList>) responseObserver);
          break;
        case METHODID_SAVE:
          serviceImpl.save((com.magalu.platform.grpc_test.TaskProto.TaskT) request,
              (io.grpc.stub.StreamObserver<com.magalu.platform.grpc_test.TaskProto.TaskList>) responseObserver);
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

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TaskServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getListMethod())
              .addMethod(getSaveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
