// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protos/req_auth_get_server_list.proto

package com.insping.libra.proto;

public final class ReqAuthGetServerList {
  private ReqAuthGetServerList() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AuthGetServerListDataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.AuthGetServerListData)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 uid = 1;</code>
     */
    long getUid();

    /**
     * <code>int32 cid = 2;</code>
     */
    int getCid();

    /**
     * <code>int32 eid = 3;</code>
     */
    int getEid();

    /**
     * <code>int32 serverType = 4;</code>
     */
    int getServerType();

    /**
     * <code>string token = 5;</code>
     */
    String getToken();
    /**
     * <code>string token = 5;</code>
     */
    com.google.protobuf.ByteString
        getTokenBytes();
  }
  /**
   * <pre>
   * 客户端验证获取服务器列表
   * </pre>
   *
   * Protobuf type {@code proto.AuthGetServerListData}
   */
  public  static final class AuthGetServerListData extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.AuthGetServerListData)
      AuthGetServerListDataOrBuilder {
    // Use AuthGetServerListData.newBuilder() to construct.
    private AuthGetServerListData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AuthGetServerListData() {
      uid_ = 0L;
      cid_ = 0;
      eid_ = 0;
      serverType_ = 0;
      token_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private AuthGetServerListData(
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

              cid_ = input.readInt32();
              break;
            }
            case 24: {

              eid_ = input.readInt32();
              break;
            }
            case 32: {

              serverType_ = input.readInt32();
              break;
            }
            case 42: {
              String s = input.readStringRequireUtf8();

              token_ = s;
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
      return ReqAuthGetServerList.internal_static_proto_AuthGetServerListData_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ReqAuthGetServerList.internal_static_proto_AuthGetServerListData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AuthGetServerListData.class, Builder.class);
    }

    public static final int UID_FIELD_NUMBER = 1;
    private long uid_;
    /**
     * <code>int64 uid = 1;</code>
     */
    public long getUid() {
      return uid_;
    }

    public static final int CID_FIELD_NUMBER = 2;
    private int cid_;
    /**
     * <code>int32 cid = 2;</code>
     */
    public int getCid() {
      return cid_;
    }

    public static final int EID_FIELD_NUMBER = 3;
    private int eid_;
    /**
     * <code>int32 eid = 3;</code>
     */
    public int getEid() {
      return eid_;
    }

    public static final int SERVERTYPE_FIELD_NUMBER = 4;
    private int serverType_;
    /**
     * <code>int32 serverType = 4;</code>
     */
    public int getServerType() {
      return serverType_;
    }

    public static final int TOKEN_FIELD_NUMBER = 5;
    private volatile Object token_;
    /**
     * <code>string token = 5;</code>
     */
    public String getToken() {
      Object ref = token_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        token_ = s;
        return s;
      }
    }
    /**
     * <code>string token = 5;</code>
     */
    public com.google.protobuf.ByteString
        getTokenBytes() {
      Object ref = token_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        token_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (cid_ != 0) {
        output.writeInt32(2, cid_);
      }
      if (eid_ != 0) {
        output.writeInt32(3, eid_);
      }
      if (serverType_ != 0) {
        output.writeInt32(4, serverType_);
      }
      if (!getTokenBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, token_);
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
      if (cid_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, cid_);
      }
      if (eid_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, eid_);
      }
      if (serverType_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, serverType_);
      }
      if (!getTokenBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, token_);
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
      if (!(obj instanceof AuthGetServerListData)) {
        return super.equals(obj);
      }
      AuthGetServerListData other = (AuthGetServerListData) obj;

      boolean result = true;
      result = result && (getUid()
          == other.getUid());
      result = result && (getCid()
          == other.getCid());
      result = result && (getEid()
          == other.getEid());
      result = result && (getServerType()
          == other.getServerType());
      result = result && getToken()
          .equals(other.getToken());
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
      hash = (37 * hash) + CID_FIELD_NUMBER;
      hash = (53 * hash) + getCid();
      hash = (37 * hash) + EID_FIELD_NUMBER;
      hash = (53 * hash) + getEid();
      hash = (37 * hash) + SERVERTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getServerType();
      hash = (37 * hash) + TOKEN_FIELD_NUMBER;
      hash = (53 * hash) + getToken().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static AuthGetServerListData parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AuthGetServerListData parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AuthGetServerListData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AuthGetServerListData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AuthGetServerListData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AuthGetServerListData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AuthGetServerListData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AuthGetServerListData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static AuthGetServerListData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static AuthGetServerListData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static AuthGetServerListData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AuthGetServerListData parseFrom(
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
    public static Builder newBuilder(AuthGetServerListData prototype) {
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
     * 客户端验证获取服务器列表
     * </pre>
     *
     * Protobuf type {@code proto.AuthGetServerListData}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.AuthGetServerListData)
        AuthGetServerListDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ReqAuthGetServerList.internal_static_proto_AuthGetServerListData_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ReqAuthGetServerList.internal_static_proto_AuthGetServerListData_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                AuthGetServerListData.class, Builder.class);
      }

      // Construct using com.insping.libra.proto.ReqAuthGetServerList.AuthGetServerListData.newBuilder()
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

        cid_ = 0;

        eid_ = 0;

        serverType_ = 0;

        token_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ReqAuthGetServerList.internal_static_proto_AuthGetServerListData_descriptor;
      }

      public AuthGetServerListData getDefaultInstanceForType() {
        return AuthGetServerListData.getDefaultInstance();
      }

      public AuthGetServerListData build() {
        AuthGetServerListData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public AuthGetServerListData buildPartial() {
        AuthGetServerListData result = new AuthGetServerListData(this);
        result.uid_ = uid_;
        result.cid_ = cid_;
        result.eid_ = eid_;
        result.serverType_ = serverType_;
        result.token_ = token_;
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
        if (other instanceof AuthGetServerListData) {
          return mergeFrom((AuthGetServerListData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(AuthGetServerListData other) {
        if (other == AuthGetServerListData.getDefaultInstance()) return this;
        if (other.getUid() != 0L) {
          setUid(other.getUid());
        }
        if (other.getCid() != 0) {
          setCid(other.getCid());
        }
        if (other.getEid() != 0) {
          setEid(other.getEid());
        }
        if (other.getServerType() != 0) {
          setServerType(other.getServerType());
        }
        if (!other.getToken().isEmpty()) {
          token_ = other.token_;
          onChanged();
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
        AuthGetServerListData parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (AuthGetServerListData) e.getUnfinishedMessage();
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

      private int cid_ ;
      /**
       * <code>int32 cid = 2;</code>
       */
      public int getCid() {
        return cid_;
      }
      /**
       * <code>int32 cid = 2;</code>
       */
      public Builder setCid(int value) {
        
        cid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 cid = 2;</code>
       */
      public Builder clearCid() {
        
        cid_ = 0;
        onChanged();
        return this;
      }

      private int eid_ ;
      /**
       * <code>int32 eid = 3;</code>
       */
      public int getEid() {
        return eid_;
      }
      /**
       * <code>int32 eid = 3;</code>
       */
      public Builder setEid(int value) {
        
        eid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 eid = 3;</code>
       */
      public Builder clearEid() {
        
        eid_ = 0;
        onChanged();
        return this;
      }

      private int serverType_ ;
      /**
       * <code>int32 serverType = 4;</code>
       */
      public int getServerType() {
        return serverType_;
      }
      /**
       * <code>int32 serverType = 4;</code>
       */
      public Builder setServerType(int value) {
        
        serverType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 serverType = 4;</code>
       */
      public Builder clearServerType() {
        
        serverType_ = 0;
        onChanged();
        return this;
      }

      private Object token_ = "";
      /**
       * <code>string token = 5;</code>
       */
      public String getToken() {
        Object ref = token_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          token_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string token = 5;</code>
       */
      public com.google.protobuf.ByteString
          getTokenBytes() {
        Object ref = token_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          token_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string token = 5;</code>
       */
      public Builder setToken(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        token_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string token = 5;</code>
       */
      public Builder clearToken() {
        
        token_ = getDefaultInstance().getToken();
        onChanged();
        return this;
      }
      /**
       * <code>string token = 5;</code>
       */
      public Builder setTokenBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        token_ = value;
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


      // @@protoc_insertion_point(builder_scope:proto.AuthGetServerListData)
    }

    // @@protoc_insertion_point(class_scope:proto.AuthGetServerListData)
    private static final AuthGetServerListData DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new AuthGetServerListData();
    }

    public static AuthGetServerListData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AuthGetServerListData>
        PARSER = new com.google.protobuf.AbstractParser<AuthGetServerListData>() {
      public AuthGetServerListData parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new AuthGetServerListData(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AuthGetServerListData> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<AuthGetServerListData> getParserForType() {
      return PARSER;
    }

    public AuthGetServerListData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_AuthGetServerListData_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_AuthGetServerListData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n%protos/req_auth_get_server_list.proto\022" +
      "\005proto\"a\n\025AuthGetServerListData\022\013\n\003uid\030\001" +
      " \001(\003\022\013\n\003cid\030\002 \001(\005\022\013\n\003eid\030\003 \001(\005\022\022\n\nserver" +
      "Type\030\004 \001(\005\022\r\n\005token\030\005 \001(\tBC\n\027com.insping" +
      ".libra.protoB\024ReqAuthGetServerList\252\002\021Lib" +
      "raClient.protob\006proto3"
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
    internal_static_proto_AuthGetServerListData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_AuthGetServerListData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_AuthGetServerListData_descriptor,
        new String[] { "Uid", "Cid", "Eid", "ServerType", "Token", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
