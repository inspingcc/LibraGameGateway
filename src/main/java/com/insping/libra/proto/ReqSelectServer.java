// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protos/req_select_server.proto

package com.insping.libra.proto;

public final class ReqSelectServer {
  private ReqSelectServer() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SelectServerDataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.SelectServerData)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 uid = 1;</code>
     */
    long getUid();

    /**
     * <code>int32 serverID = 2;</code>
     */
    int getServerID();
  }
  /**
   * <pre>
   * 选择服务器
   * </pre>
   *
   * Protobuf type {@code proto.SelectServerData}
   */
  public  static final class SelectServerData extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.SelectServerData)
      SelectServerDataOrBuilder {
    // Use SelectServerData.newBuilder() to construct.
    private SelectServerData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SelectServerData() {
      uid_ = 0L;
      serverID_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private SelectServerData(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              uid_ = input.readInt64();
              break;
            }
            case 16: {

              serverID_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ReqSelectServer.internal_static_proto_SelectServerData_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ReqSelectServer.internal_static_proto_SelectServerData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              SelectServerData.class, Builder.class);
    }

    public static final int UID_FIELD_NUMBER = 1;
    private long uid_;
    /**
     * <code>int64 uid = 1;</code>
     */
    public long getUid() {
      return uid_;
    }

    public static final int SERVERID_FIELD_NUMBER = 2;
    private int serverID_;
    /**
     * <code>int32 serverID = 2;</code>
     */
    public int getServerID() {
      return serverID_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (uid_ != 0L) {
        output.writeInt64(1, uid_);
      }
      if (serverID_ != 0) {
        output.writeInt32(2, serverID_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (uid_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, uid_);
      }
      if (serverID_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, serverID_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof SelectServerData)) {
        return super.equals(obj);
      }
      SelectServerData other = (SelectServerData) obj;

      boolean result = true;
      result = result && (getUid()
          == other.getUid());
      result = result && (getServerID()
          == other.getServerID());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + UID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getUid());
      hash = (37 * hash) + SERVERID_FIELD_NUMBER;
      hash = (53 * hash) + getServerID();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static SelectServerData parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SelectServerData parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SelectServerData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SelectServerData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SelectServerData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SelectServerData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SelectServerData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static SelectServerData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static SelectServerData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static SelectServerData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static SelectServerData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static SelectServerData parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(SelectServerData prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * <pre>
     * 选择服务器
     * </pre>
     *
     * Protobuf type {@code proto.SelectServerData}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.SelectServerData)
        SelectServerDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ReqSelectServer.internal_static_proto_SelectServerData_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ReqSelectServer.internal_static_proto_SelectServerData_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                SelectServerData.class, Builder.class);
      }

      // Construct using com.insping.libra.proto.ReqSelectServer.SelectServerData.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        uid_ = 0L;

        serverID_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ReqSelectServer.internal_static_proto_SelectServerData_descriptor;
      }

      public SelectServerData getDefaultInstanceForType() {
        return SelectServerData.getDefaultInstance();
      }

      public SelectServerData build() {
        SelectServerData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public SelectServerData buildPartial() {
        SelectServerData result = new SelectServerData(this);
        result.uid_ = uid_;
        result.serverID_ = serverID_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof SelectServerData) {
          return mergeFrom((SelectServerData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(SelectServerData other) {
        if (other == SelectServerData.getDefaultInstance()) return this;
        if (other.getUid() != 0L) {
          setUid(other.getUid());
        }
        if (other.getServerID() != 0) {
          setServerID(other.getServerID());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        SelectServerData parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (SelectServerData) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long uid_ ;
      /**
       * <code>int64 uid = 1;</code>
       */
      public long getUid() {
        return uid_;
      }
      /**
       * <code>int64 uid = 1;</code>
       */
      public Builder setUid(long value) {
        
        uid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 uid = 1;</code>
       */
      public Builder clearUid() {
        
        uid_ = 0L;
        onChanged();
        return this;
      }

      private int serverID_ ;
      /**
       * <code>int32 serverID = 2;</code>
       */
      public int getServerID() {
        return serverID_;
      }
      /**
       * <code>int32 serverID = 2;</code>
       */
      public Builder setServerID(int value) {
        
        serverID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 serverID = 2;</code>
       */
      public Builder clearServerID() {
        
        serverID_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:proto.SelectServerData)
    }

    // @@protoc_insertion_point(class_scope:proto.SelectServerData)
    private static final SelectServerData DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new SelectServerData();
    }

    public static SelectServerData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SelectServerData>
        PARSER = new com.google.protobuf.AbstractParser<SelectServerData>() {
      public SelectServerData parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new SelectServerData(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SelectServerData> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<SelectServerData> getParserForType() {
      return PARSER;
    }

    public SelectServerData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_SelectServerData_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_SelectServerData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\036protos/req_select_server.proto\022\005proto\"" +
      "1\n\020SelectServerData\022\013\n\003uid\030\001 \001(\003\022\020\n\010serv" +
      "erID\030\002 \001(\005B>\n\027com.insping.libra.protoB\017R" +
      "eqSelectServer\252\002\021LibraClient.protob\006prot" +
      "o3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_proto_SelectServerData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_SelectServerData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_SelectServerData_descriptor,
        new String[] { "Uid", "ServerID", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
