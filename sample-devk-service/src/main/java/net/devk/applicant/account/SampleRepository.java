package net.devk.applicant.account;

import net.devk.applicant.model.SampleEntity;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

//
@Repository
interface SampleRepository extends FullEntityRepository<SampleEntity, Long> {
}