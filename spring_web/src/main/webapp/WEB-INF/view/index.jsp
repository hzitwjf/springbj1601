<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/27
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Complex DataGrid - jQuery EasyUI Demo</title>
  <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
  <script type="text/javascript" src="js/jquery-3.0.0.js"></script>
  <script type="text/javascript" src="easyui/js/jquery.easyui.min.js"></script>
  <script type="text/javascript">
    $(function(){
      $('#test').datagrid({
        title:'学员信息表',
        iconCls:'icon-save',
        width:700,
        height:350,
        nowrap: true,
        autoRowHeight: false,
        striped: true,
        collapsible:true,
        url:'datagrid_data.json',
        sortName: 'code',
        sortOrder: 'desc',
        remoteSort: false,
        idField:'code',
        frozenColumns:[[
          {field:'ck',checkbox:true},
          {title:'Code',field:'code',width:80,sortable:true}
        ]],
        columns:[[
          {title:'详细信息',colspan:9},
          {field:'opt',title:'',width:100,align:'center',
            formatter:function(value,rec){
              return '<span style="color:red">Edit Delete</span>';
            }
          }
        ],[
          {field:'name',title:'学生名字',width:120},
          {field:'addr',title:'地址',width:220,rowspan:2,sortable:true,
            sorter:function(a,b){
              return (a>b?1:-1);
            }
          },
          {field:'col4',title:'学生性别',width:150},
          {field:'col4',title:'登录密码',width:150},
          {field:'col4',title:'出生日期',width:150},
          {field:'col4',title:'邮箱',width:150},
          {field:'col4',title:'电话',width:150},
          {field:'col4',title:'出生日期',width:150},
          {field:'col4',title:'身份证号',width:150}
        ]],

        pagination:true,
        rownumbers:true,
        toolbar:[{
          id:'btnadd',
          text:'新增学生',
          iconCls:'icon-add',
          handler:function(){
            $('#btnsave').linkbutton('enable');
            alert('add')
          }
        },{
          id:'btncut',
          text:'删除学生',
          iconCls:'icon-cut',
          handler:function(){
            $('#btnsave').linkbutton('enable');
            alert('cut')
          }
        },'-',{
          id:'btnsave',
          text:'保存',
          disabled:true,
          iconCls:'icon-save',
          handler:function(){
            $('#btnsave').linkbutton('disable');
            alert('save')
          }
        }]
      });
      var p = $('#test').datagrid('getPager');
      $(p).pagination({
        onBeforeRefresh:function(){
          alert('before refresh');
        }
      });
    });
    function resize(){
      $('#test').datagrid('resize', {
        width:700,
        height:400
      });
    }
    function getSelected(){
      var selected = $('#test').datagrid('getSelected');
      if (selected){
        alert(selected.code+":"+selected.name+":"+selected.addr+":"+selected.col4);
      }
    }
    function getSelections(){
      var ids = [];
      var rows = $('#test').datagrid('getSelections');
      for(var i=0;i<rows.length;i++){
        ids.push(rows[i].code);
      }
      alert(ids.join(':'));
    }
    function clearSelections(){
      $('#test').datagrid('clearSelections');
    }
    function selectRow(){
      $('#test').datagrid('selectRow',2);
    }
    function selectRecord(){
      $('#test').datagrid('selectRecord','002');
    }
    function unselectRow(){
      $('#test').datagrid('unselectRow',2);
    }
    function mergeCells(){
      $('#test').datagrid('mergeCells',{
        index:2,
        field:'addr',
        rowspan:2,
        colspan:2
      });
    }
  </script>
</head>
<body>
<table id="test">

</table>

</body>
</html>