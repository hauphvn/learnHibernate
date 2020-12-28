# learnHibernate

### Annotation

- @Entity và @Table: thuộc level : `Class`. Entity là Required. Thuộc tính `name` của annotation này là tên của table trong database. 
- @GeneratedValue: `AUTO` - hibernate tự động chọn chiếc lược generated cho class model;
`ENTITY` - các class kế thừa nhau sẽ liên quan với nhau về giá trị id tự động tăng;
`SEQUENCE` - người dùng định nghĩa ra một giá trị tự động tăng ban đầu;
`TABLE`  - áp dụng cho tên table.
- @Transient: được dùng khi mà lập trình viên chỉ muốn áp dụng trong code java, không muốn lưu xuống db
- @Temporal: cho phép tùy biến lưu data xuống db liên quan đến thời gian như ngày tháng năm giờ phút giấy
- @Embedded và @Embeddable: cho phép một object chứa trong một object khác;
- @ElementCollection: cho phép một object chứa một list, khi đó hibernate sẽ tạo một table mới trong database.
- Proxy Object: là object tạm thời được tạo ra trong qua trình run time để lấy ra database. Nó sẽ extend class mà nó đang sử dụng.
Che giấu cơ chế lazy loading.
- Lazy loading: nếu một thuộc tính trong object để chế độ: `@ElementCollection(fecth=FetchType.LAZY` thì khi hibernate truy vấn db sẽ không select
 thuộc tính này ra nếu như bên code java chúng ta không gọi.
- Eager loading: hibernate luôn select * tấc cả thuộc tính ra object.
- @OneToOne: đặt 1 annotation bên 1 class.
- @OneToMany và @ManyToOne: xét xem object A và B cái nào quan trọng. Ví dụ: Một A có nhiều B. Nếu ta quan tâm đến object A quan trọng hơn, thì đặt
 bên
 object
 A l
à `@OneToMany`. Ngược lại nếu ta quan tâm đến B thì ta đặt trong B là `@ManyToOne`.
- `@ManyMany` - 1 A có nhiều B, 1 B có nhiều A, thì trong mỗi class A và B sẽ có một List tương ứng, khi đó mỗi List đó sẽ có annotation @ManyToMany.


### Query 
- **CRUD**: 
    - Create: session.save();
    - Read: session.get();
    - Update: session.update()
    - Delete: session.delete()
    
   *Lưu ý:* mọi thao tác với db đều phải cần `session.getTransaction.commit()`.

### HQL

- SQl là ngôn ngữ dùng trong database, HQL là ngôn ngữ dùng thao tác với các object sau khi đã query từ db ra.
- Khi sử dụng HQL sẽ có những ưu điểm của SQL generation và caching.
### Lỗi thường gặp

- MappingException UnknownEntity: sửa lỗi ref: [stackoverflow](https://stackoverflow.com/a/34519170)

```java
 Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.coderzero.model.Course.class);
```
- Lỗi tạo Engine MyISAM: thêm vào trong file cấu hình hibernate.cfg.xml
```java
 <property name="hibernate.dialect">
            org.hibernate.dialect.MySQL57Dialect
        </property>
```
### Note

- hbm2ddl: Hibernate mapping to DDL(Data definition Language; liên quan đến việc chỉnh sửa schema).
Những giá trị của hbm2ddl: `note` - không làm gì; `validate`- xem xét sự đúng đắn của schema; `update` - sau khi đã created rồi thì chúng ta chỉ s
ẽ cập nhật; `create` - tạo mới schema, xóa giá trị của bảng trước đó; `create-drop` - shema sẽ bị xóa khi SessionFactory bị đóng.

- Object status: trong hibernate có 3 trạng thái của một đối tượng sau khi mapping:
`transient` - được tạo khi sử dụng constructor của class, chưa liên kết với session của hibernate, chưa có một record nào trong database nào liên k
ết với object này; `persistent` - object đã được liên kết với record trong db; `detacked` - object này trước đó đã được liên kế với record với db
 nhưng session đã bị closed.