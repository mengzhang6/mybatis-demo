package meng.mybatis.pic;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class PicBlobTypeHandler extends BaseTypeHandler<InputStream> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			InputStream parameter, JdbcType jdbcType) throws SQLException {
		try {
			ps.setBinaryStream(i, parameter, parameter.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public InputStream getNullableResult(ResultSet rs, String columnName)
			throws SQLException {

		Blob blob = rs.getBlob(columnName);
		byte[] returnValue = null;
		InputStream result = null;
		if (null != blob) {
			returnValue = blob.getBytes(1, (int) blob.length());
		}
		if (null != returnValue) {
			result = new ByteArrayInputStream(returnValue);
		}
		return result;
	}

	@Override
	public InputStream getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		ByteArrayInputStream result = null;
		Blob blob = rs.getBlob(columnIndex);
		byte[] returnValue = null;
		if (null != blob) {
			returnValue = blob.getBytes(1, (int) blob.length());
		}
		if (null != returnValue) {
			result = new ByteArrayInputStream(returnValue);
		}
		return result;
	}

	@Override
	public InputStream getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		Blob blob = cs.getBlob(columnIndex);
		byte[] returnValue = null;
		InputStream result = null;
		if (null != blob) {
			returnValue = blob.getBytes(1, (int) blob.length());
		}
		if (null != returnValue) {
			result = new ByteArrayInputStream(returnValue);
		}
		return result;
	}

}
